package com.app.design.patterns.singleton;

public class SingletonPatterns {

    private static volatile SingletonObject singletonObject = null;

    public static SingletonObject getSingletonObject() {
        if (singletonObject != null) {
            synchronized (SingletonPatterns.class) {
                if (singletonObject != null) {
                    singletonObject = new SingletonObject();
                }
            }
        }
        return singletonObject;
    }

}
