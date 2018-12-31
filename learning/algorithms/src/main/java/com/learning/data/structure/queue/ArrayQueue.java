package com.learning.data.structure.queue;

public class ArrayQueue<T> implements Queue<T> {

    /** 初始容量为16 */
    private static final int DEFAULT_SIZE = 2 << 3;

    private Object[] stack;

    private int header = 0;

    private int tail = 0;

    public ArrayQueue() {
        stack = new Object[DEFAULT_SIZE];
    }

    public ArrayQueue(int size) {
        stack = new Object[size];
    }

    @Override
    public boolean enqueue(T t) {
        if (tail >= stack.length) {
            if (header == 0) {
                return false;
            } else {
                move();
            }
        }
        stack[tail++] = t;
        return true;
    }

    @Override
    public T dequeue() {
        if (header >= tail) {
            return null;
        }
        T item = (T) stack[header];
        stack[header] = null;
        header++;
        return item;
    }

    private void move() {
        for (int i = 0; i < tail - header; i++) {
            stack[i] = stack[header + i];
            stack[header + i] = null;
        }
        tail = tail - header;
        header = 0;
    }
}
