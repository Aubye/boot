package org.orgin.helper;

import com.google.common.collect.Sets;
import org.orgin.annotations.bean.Controller;
import org.orgin.annotations.bean.Service;
import org.orgin.factory.ConfigFactory;
import org.orgin.utils.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ClassHelper {

    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigFactory.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包名下所有的类
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取应用包名下所有的Controller类
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> serviceClassSet = Sets.newHashSet();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Controller.class)) {
                serviceClassSet.add(cls);
            }
        }
        return serviceClassSet;
    }

    /**
     * 获取应用包名下所有的Service类
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> serviceClassSet = Sets.newHashSet();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                serviceClassSet.add(cls);
            }
        }
        return serviceClassSet;
    }

    /**
     * 获取应用包名下所有的Bean类(Controller, Service)
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClassSet = Sets.newHashSet();
        beanClassSet.addAll(getControllerClassSet());
        beanClassSet.addAll(getServiceClassSet());
        return beanClassSet;
    }

    public static Set<Class<?>> getAnnotationClassSet(Class<? extends Annotation> annotation) {
        return CLASS_SET.stream()
                .filter(cls -> cls.isAnnotationPresent(annotation))
                .collect(toSet());
    }

}
