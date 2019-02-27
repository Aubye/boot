package org.orgin.aspect;

import org.orgin.annotations.aop.Aspect;
import org.orgin.annotations.bean.Controller;
import org.orgin.proxy.AspectPorxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 拦截Controller所有方法
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectPorxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.info("-------------------------------- begin --------------------------------");
        LOGGER.info("class:{}", cls.getName());
        LOGGER.info("method:{}", method.getName());
        begin = System.nanoTime();
        LOGGER.info("ControllerAspect.before.begin:{}", begin);
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params) throws Throwable {
        long time = System.nanoTime();
        LOGGER.info("ControllerAspect.after.time:{}", time);
        LOGGER.info("ControllerAspect.after.interval:{}", time - begin);
        LOGGER.info("-------------------------------- end --------------------------------");
    }

}
