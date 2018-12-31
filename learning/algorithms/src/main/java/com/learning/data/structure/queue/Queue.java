package com.learning.data.structure.queue;

public interface Queue<T> {

    boolean enqueue(T t);

    T dequeue();

}
