package org.orgin.factory;

import com.app.smart.origins.annotations.bean.Component;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

public class BeanFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanFactory.class);

    public static Map<Class<?>, Object> BEAN_MAP = Maps.newConcurrentMap();

    static {
        Set<Class<?>> beanClassSet = ClassFactory.getBeanClassSet();
        beanClassSet.forEach(beanClass -> {
            buildBeanContext(beanClass);
            //带有@Fresh注解为多例,每次依赖注入都进行类的初始化，不加入实例中
            if (!beanClass.isAnnotationPresent(Component.class)) {
            }
        });
    }

    private static void buildBeanContext(Class<?> beanClass) {

    }

}
