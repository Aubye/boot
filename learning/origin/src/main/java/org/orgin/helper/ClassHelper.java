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

    /**
     * 获取应用包下某父类(或接口)的所有子类(或实现类)
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = Sets.newHashSet();
        for (Class<?> cls : CLASS_SET) {
            if (superClass.isAssignableFrom(cls) && !superClass.equals(cls)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }


    /**
     * 获取应用包下带有某注解的所有类
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotation) {
        return CLASS_SET.stream()
                .filter(cls -> cls.isAnnotationPresent(annotation))
                .collect(toSet());
    }

}
