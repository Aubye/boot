package org.orgin.helper;

import org.orgin.annotations.ioc.Inject;
import org.orgin.utils.MapUtil;
import org.orgin.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

public class IocHelper {

    static {
        Map<Class<?>, Object> beanMap = BeanHepler.getBeanMap();
        if (MapUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
                Class<?> beanClass = entry.getKey();
                Object beanInstance = entry.getValue();
                Field[] beanClassFields = beanClass.getDeclaredFields();
                for (Field beanClassField : beanClassFields) {
                    if (beanClassField.isAnnotationPresent(Inject.class)) {
                        Class<?> injectBeanClass = beanClassField.getType();
                        Object injectBeanInstance = beanMap.get(injectBeanClass);
                        if (injectBeanInstance != null) {
                            ReflectionUtil.setField(beanInstance, beanClassField, injectBeanInstance);
                        }
                    }
                }
            }
        }
    }

}
