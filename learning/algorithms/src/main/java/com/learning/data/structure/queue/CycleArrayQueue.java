package com.learning.data.structure.queue;

public class CycleArrayQueue<T> implements Queue<T> {

    private static final int DEFAULT_SIZE = 2 << 3;

    private Object[] items;

    private int header;

    private int tail;

    public CycleArrayQueue() {
        items = new Object[DEFAULT_SIZE];
    }

    public CycleArrayQueue(int size) {
        items = new Object[size];
    }

    @Override
    public boolean enqueue(T t) {
        if (isFull()) {
            return false;
        }
        items[tail++] = t;
        tail = tail % items.length;

        return true;
    }

    @Override
    public T dequeue() {
        return null;
    }

    private boolean isFull() {
        // tail的下一位应该是header，因为队列是循环的，所以取余
        return (tail + 1) % items.length == header;
    }
}
