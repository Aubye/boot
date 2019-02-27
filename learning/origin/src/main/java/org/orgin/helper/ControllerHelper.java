package org.orgin.helper;

import com.google.common.collect.Maps;
import org.orgin.annotations.controller.Action;
import org.orgin.bean.controller.Handler;
import org.orgin.bean.controller.Request;
import org.orgin.emnu.RequestMethod;
import org.orgin.utils.ArrayUtil;
import org.orgin.utils.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public class ControllerHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerHelper.class);

    private static final Map<Request, Handler> ACTION_MAP = Maps.newConcurrentMap();

    static {
        //获取所有@Controller注解的Class类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            for (Class<?> controllerClass : controllerClassSet) {
                //反射获取ControllerClass类所有的方法
                Method[] controllerClassMethods = controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(controllerClassMethods)) {
                    for (Method controllerClassMethod : controllerClassMethods) {
                        //获取ControllerClass类中带有@Action注解的方法
                        if (controllerClassMethod.isAnnotationPresent(Action.class)) {
                            //获取带有@Action注解的方法的value(url)和method(GET/POST)
                            Action actionAnnotation = controllerClassMethod.getAnnotation(Action.class);
                            String mapping = actionAnnotation.value();
                            RequestMethod method = actionAnnotation.method();
                            Request request = new Request(mapping, method);
                            Handler handler = new Handler(controllerClass, controllerClassMethod);
                            ACTION_MAP.put(request, handler);
                        }
                    }
                }
            }
        }
    }

    public static Handler getHandler(RequestMethod requestMethod, String requestMapping) {
        Request request = new Request(requestMapping, requestMethod);
        return ACTION_MAP.get(request);
    }
}
