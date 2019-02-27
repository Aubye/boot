package org.orgin.factory;

import com.app.smart.origins.annotations.bean.Component;
import com.app.smart.origins.annotations.bean.Controller;
import com.app.smart.origins.annotations.bean.Service;
import com.app.smart.origins.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ClassFactory {

    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigFactory.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    public static Set<Class<?>> getControllerClassSet() {
        return getAnnotationClassSet(Controller.class);
    }

    public static Set<Class<?>> getServiceClassSet() {
        return getAnnotationClassSet(Service.class);
    }

    public static Set<Class<?>> getBeanClassSet() {
        return CLASS_SET.stream()
                .filter(cls -> cls.isAnnotationPresent(Controller.class) ||
                        cls.isAnnotationPresent(Service.class) ||
                        cls.isAnnotationPresent(Component.class))
                .collect(toSet());
    }

    public static Set<Class<?>> getAnnotationClassSet(Class<? extends Annotation> annotation) {
        return CLASS_SET.stream()
                .filter(cls -> cls.isAnnotationPresent(annotation))
                .collect(toSet());
    }

}
