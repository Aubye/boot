package org.orgin.helper;

import com.google.common.collect.Maps;
import org.orgin.utils.ReflectionUtil;

import java.util.Map;
import java.util.Set;

public class BeanHepler {

    /**
     * Bean映射,存放Bean类与实例的关系
     */
    private static final Map<Class<?>, Object> BEAN_MAP = Maps.newConcurrentMap();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object beanInstance = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, beanInstance);
        }
    }

    //获取Bean映射
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取Bean实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<?> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get bean by class: " + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }

}
