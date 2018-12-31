package com.learning.data.structure.stack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {

    /** 初始长度为8 */
    private static final int DEFAULT_SIZE = 2 << 2;

    private Object[] stack;

    private int count = 0;

    public ArrayStack() {
        stack = new Object[DEFAULT_SIZE];
    }

    public ArrayStack(int size) {
        stack = new Object[size];
    }

    @Override
    public void push(T t) {
        if (count >= stack.length) {
            grow();
        }
        stack[count++] = t;
    }

    @Override
    public T pop() {
        if (count > 0) {
            T item = (T) stack[--count];
            stack[count] = null;
            return item;
        } else {
            return null;
        }
    }

    @Override
    public T peek() {
        return count > 0 ? (T) stack[count - 1] : null;
    }

    private void grow() {
        int oldStackCapacity = stack.length;
        int newStackCapacity = oldStackCapacity + (oldStackCapacity >> 1);
        stack = Arrays.copyOf(stack, newStackCapacity);
    }

}
