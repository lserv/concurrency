package io.lenur.concurrency.multithreading.collection;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        Thread thread = new Thread(() -> addNumbers(queue));
        thread.start();

        addNumbers(queue);
        thread.join();
        System.out.println(queue.size());//1000
    }

    private static void addNumbers(Queue<Integer> queue) {
        for (int i=0; i < 500; i++) {
            queue.add(i);
        }
    }
}
