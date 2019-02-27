package org.orgin.proxy;

import org.modelmapper.internal.cglib.proxy.Enhancer;
import org.modelmapper.internal.cglib.proxy.MethodInterceptor;
import org.orgin.annotations.proxy.Proxy;

import java.util.List;

public class ProxyManager {

//    @SuppressWarnings("unchecked")
//    public static <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList) {
//        return (T) Enhancer.create(targetClass, new MethodInterceptor() {
//            @Override
//            public Object intercept(Object targetObject, Method targetMethod, Object[] methodParams, MethodProxy methodProxy) {
//                return new ProxyChain(targetClass, targetObject, targetMethod, methodProxy, methodParams, proxyList);
//            }
//        });
//    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList) {
        return (T) Enhancer.create(targetClass, (MethodInterceptor) (targetObject, targetMethod, methodParams, methodProxy) ->
                new ProxyChain(targetClass, targetObject, targetMethod, methodProxy, methodParams, proxyList));
    }

}
