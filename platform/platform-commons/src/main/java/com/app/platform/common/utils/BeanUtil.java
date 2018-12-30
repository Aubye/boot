package com.app.platform.common.utils;

import com.app.platform.common.utils.annotation.Ignore;
import com.app.platform.common.utils.annotation.Transfer;
import com.app.platform.common.utils.bean.ClassInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.app.platform.common.utils.StringUtil.isNotEmpty;

public final class BeanUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanUtil.class);

    private BeanUtil() {
    }

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        T target = ReflectionUtil.newInstance(targetClass);
        copyProperties(source, target);
        return target;
    }

    public static void copyProperties(Object source, Object target) {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();
        ClassInfo sourceClassInfo = ClassUtil.getClassInfo(sourceClass);
        ClassInfo targetClassInfo = ClassUtil.getClassInfo(targetClass);
        List<Field> sourceClassDeclaredFields = sourceClassInfo.getFields().stream()
                .filter(field -> !field.isAnnotationPresent(Ignore.class)).collect(Collectors.toList());
        Map<String, Field> targetClassInfoFieldMap = targetClassInfo.getFieldMap();

        sourceClassDeclaredFields.forEach(fieldTransfer(source, target, targetClass, targetClassInfoFieldMap));
    }

    private static Consumer<Field> fieldTransfer(Object source, Object target, Class<?> targetClass, Map<String, Field> targetClassInfoFieldMap) {
        return sourceField -> {
            Object sourceFieldValue = ReflectionUtil.getField(sourceField, source);
            if (sourceFieldValue != null) {
                String targetFieldName = getTargetFieldName(sourceField);
                Field targetField = targetClassInfoFieldMap.get(targetFieldName);
                if (targetField != null && !Modifier.isFinal(targetField.getModifiers())) {
                    transfer(target, sourceField, sourceFieldValue, targetField);
                } else {
                    LOGGER.warn("cannot find can modify targetField {} in {} ", targetFieldName, targetClass);
                }
            }
        };
    }

    private static void transfer(Object target, Field sourceField, Object sourceFieldValue, Field targetField) {
        //Determines if the class or interface represented by this, inject value
        if (targetField.getType().equals(sourceField.getType()) || targetField.getType().isAssignableFrom(sourceField.getType())) {
            ReflectionUtil.setField(target, targetField, sourceFieldValue);
        } else {
            LOGGER.info("cannot copy field {} to class {}", sourceField.getName(), target.getClass().getName());
        }
    }

    private static String getTargetFieldName(Field sourceField) {
        //如果字段上使用了@Transfer则取出value看是否为空字符串，如果不为空则取value，否则取字段名
        return sourceField.isAnnotationPresent(Transfer.class)
                ? isNotEmpty(sourceField.getAnnotation(Transfer.class).value()) ? sourceField.getAnnotation(Transfer.class).value() : sourceField.getName()
                : sourceField.getName();
    }

    public static Map<String, Object> toMap(Object obj) {
        return ReflectionUtil.getFields(obj.getClass()).stream().collect(Collectors.toMap(Field::getName, field -> ReflectionUtil.getField(field, obj)));
    }

    public static Boolean checkAllFieldIsNull(Object bean) {
        return Objects.isNull(bean)
                ? Boolean.TRUE
                : ClassUtil.getClassInfo(bean.getClass()).getFields().stream()
                .map(field -> ReflectionUtil.getField(field, bean))
                .noneMatch(Objects::nonNull);
    }
}
