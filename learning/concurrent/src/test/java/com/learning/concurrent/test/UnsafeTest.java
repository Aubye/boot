package com.learning.concurrent.test;

import com.learning.concurrent.utils.UnsafeUtil;
import sun.misc.Unsafe;

public class UnsafeTest {

    public static void main(String[] args) {
        UnsafeUtil unsafeUtil = UnsafeUtil.getInstance();
        Unsafe unsafe = unsafeUtil.getUnsafe();
        System.out.println(unsafe.toString());
    }

}
