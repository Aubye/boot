package com.learning.data.structure.queue;


import org.junit.Test;

public class QueueTest {

    @Test
    public void testArrayQueue() {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            System.out.println(queue.enqueue(i + 1));
        }
        System.out.println("enqueue item number:20");
        for (int i = 0; i < 20; i++) {
            System.out.println(queue.dequeue());
        }
        System.out.println("dequeue item number:20 all");

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.enqueue(i + 1));
        }
        System.out.println("enqueue item number:10");

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }
        System.out.println("dequeue item number:10 all");

        for (int i = 0; i < 20; i++) {
            System.out.println(queue.enqueue(i + 1));
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(queue.dequeue());
        }
    }

}
