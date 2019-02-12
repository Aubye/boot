package org.orgin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     */
    public static <T> T newInstance(Class<T> cls) {
        Object instance;
        try {
            //instance = cls.newInstance(); 废弃
            instance = cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            LOGGER.error("new instance failure", e);
            throw new RuntimeException(e);
        }
        return (T) instance;
    }

    /**
     * 调用方法
     */
    public static Object invokeMethod(Object obj, Method method, Object... args) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (Exception e) {
            LOGGER.error("ReflectionUtil.invokeMethod.error, e:{}", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 获取成员变量的值
     */
    public static Object getField(Object obj, Field field) {
        Object value;
        try {
            field.setAccessible(true);
            value =  field.get(obj);
        } catch (Exception e) {
            LOGGER.error("ReflectionUtil.invokeMethod.error, e:{}", e);
            throw new RuntimeException(e);
        }
        return value;
    }

    /**
     * 设置成员变量的值
     */
    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            LOGGER.error("ReflectionUtil.invokeMethod.error, e:{}", e);
            throw new RuntimeException(e);
        }
    }


}
