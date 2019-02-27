package org.orgin.utils;

import org.orgin.annotations.bean.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class BeanUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanUtil.class);

    private static final String SERIAL_VERSION_UID = "serialVersionUID";

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        T target = ReflectionUtil.newInstance(targetClass);
        copyProperties(source, target);
        return target;
    }

    private static void copyProperties(Object source, Object target) {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();

        Field[] sourceClassFields = sourceClass.getFields();
        List<Field> sourceClassDeclaredFields = Arrays.stream(sourceClassFields)
                .filter(field -> !field.isAnnotationPresent(Ignore.class))
                .filter(field -> !field.getName().equals(SERIAL_VERSION_UID))
                .collect(Collectors.toList());

        Field[] targetClassFields = targetClass.getFields();
        Map<String, Field> targetClassFieldMap = Arrays.stream(targetClassFields)
                .filter(field -> !field.getName().equals(SERIAL_VERSION_UID))
                .collect(Collectors.toMap(Field::getName, Function.identity()));

        for (Field sourceClassDeclaredField : sourceClassDeclaredFields) {
            String sourceFieldName = sourceClassDeclaredField.getName();
            Object value = ReflectionUtil.getField(source, sourceClassDeclaredField);
            if (value != null && targetClassFieldMap.get(sourceFieldName) != null) {
                Field targetClassDeclaredField = targetClassFieldMap.get(sourceFieldName);
                Class<?> targetFieldDeclaringClass = targetClassDeclaredField.getDeclaringClass();
                Class<?> sourceFieldDeclaringClass = sourceClassDeclaredField.getDeclaringClass();
                if (targetFieldDeclaringClass.equals(sourceFieldDeclaringClass)) {
                    ReflectionUtil.setField(target, targetClassDeclaredField, value);
                }
            }
        }
    }

}
