package org.orgin.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {

    private static CglibDynamicProxy instance = new CglibDynamicProxy();

    public CglibDynamicProxy() {
    }

    public static CglibDynamicProxy getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(object, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("CglibDynamicProxy.invoke.before");
    }

    private void after() {
        System.out.println("CglibDynamicProxy.invoke.after");
    }

}
