package org.orgin.loader;

import org.orgin.helper.BeanHepler;
import org.orgin.helper.ClassHelper;
import org.orgin.helper.ControllerHelper;
import org.orgin.helper.IocHelper;
import org.orgin.utils.ClassUtil;

public class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHepler.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
     }

}
