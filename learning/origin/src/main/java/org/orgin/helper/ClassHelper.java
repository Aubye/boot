package org.orgin.helper;

import com.app.smart.origins.factory.ConfigFactory;
import com.app.smart.origins.util.ClassUtil;

import java.util.Set;

public class ClassHelper {

    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigFactory.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    public static Set<Class<?>> getServiceClassSet() {
        return CLASS_SET;
    }

}
