package org.orgin.loader;

import org.orgin.helper.*;
import org.orgin.utils.ClassUtil;

public class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHepler.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            //ClassUtil.loadClass(cls.getName());
            ClassUtil.loadClass(cls.getName(), true);
            //AOP必须要在IOC之前加载!!!
        }
     }

}
