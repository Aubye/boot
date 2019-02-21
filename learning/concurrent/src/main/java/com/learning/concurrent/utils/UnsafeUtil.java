package com.learning.concurrent.utils;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeUtil {

    private static final String THE_UNSAFE = "theUnsafe";

    private Unsafe unsafe;

    public static UnsafeUtil getInstance() {
        return new UnsafeUtil();
    }

    public Unsafe getUnsafe() {
        if (unsafe == null) {
            try {
                Field field = Unsafe.class.getDeclaredField(THE_UNSAFE);
                field.setAccessible(true);
                unsafe = (Unsafe) field.get(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return unsafe;
    }

}
