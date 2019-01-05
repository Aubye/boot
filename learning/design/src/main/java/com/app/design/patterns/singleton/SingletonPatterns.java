package com.app.design.patterns.singleton;

public class SingletonPatterns {

    private volatile static SingletonObject singletonObject = null;

    public static SingletonObject getSingletonObject() {
        if (singletonObject != null) {
            synchronized (SingletonPatterns.class) {
                singletonObject = new SingletonObject();
            }
        }
        return singletonObject;
    }

}
