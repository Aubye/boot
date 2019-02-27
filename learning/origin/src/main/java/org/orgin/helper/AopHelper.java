package org.orgin.helper;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.orgin.annotations.aop.Aspect;
import org.orgin.annotations.proxy.Proxy;
import org.orgin.proxy.AspectPorxy;
import org.orgin.proxy.ProxyManager;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AopHelper {

    static {
        try {
            Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
            Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);
            for (Map.Entry<Class<?>, List<Proxy>> targetEntry : targetMap.entrySet()) {
                Class<?> targetClass = targetEntry.getKey();
                List<Proxy> proxyList = targetEntry.getValue();
                Object proxy = ProxyManager.createProxy(targetClass, proxyList);
                BeanHepler.setBean(targetClass, proxy);
            }
        } catch (Exception e) {

        }
    }

    /**
     * 获取带有Aspect注解的所有类
     */
    private static Set<Class<?>> createTargetClassSet(Aspect aspect) throws Exception {
        Set<Class<?>> targetClassSet = Sets.newHashSet();
        Class<? extends Annotation> annotation = aspect.value();
        if (annotation != null && !annotation.equals(Aspect.class)) {
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }
        return targetClassSet;
    }

    /**
     * 获取代理类和其实现类的映射关系(可能是一对多的)
     */
    private static Map<Class<?>, Set<Class<?>>> createProxyMap() throws Exception {
        Map<Class<?>, Set<Class<?>>> proxyMap = Maps.newHashMap();
        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectPorxy.class);
        for (Class<?> proxyClass : proxyClassSet) {
            Aspect aspect = proxyClass.getAnnotation(Aspect.class);
            Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
            proxyMap.put(proxyClass, targetClassSet);
        }
        return proxyMap;
    }

    /**
     * 获取代理类与代理对象列表的关系
     */
    private static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {
        Map<Class<?>, List<Proxy>> targetMap = Maps.newHashMap();
        for (Map.Entry<Class<?>, Set<Class<?>>> proxyEntry : proxyMap.entrySet()) {
            Class<?> proxyClass = proxyEntry.getKey();
            Set<Class<?>> targetClassSet = proxyEntry.getValue();
            for (Class<?> targetClass : targetClassSet) {
                //创建类实例即代理类(父类/接口)
                Proxy proxy = (Proxy) proxyClass.getDeclaredConstructor().newInstance();
                if (targetMap.containsKey(targetClass)) {
                    targetMap.get(targetClass).add(proxy);
                } else {
                    List<Proxy> proxyList = Lists.newArrayList();
                    proxyList.add(proxy);
                    targetMap.put(targetClass, proxyList);
                }
            }
        }
        return targetMap;
    }

}
