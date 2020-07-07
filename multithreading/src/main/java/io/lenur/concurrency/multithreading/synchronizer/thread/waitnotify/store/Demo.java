package io.lenur.concurrency.multithreading.synchronizer.thread.waitnotify.store;

public class Demo {
    public static void main(String[] args) {
        Store store = new Store();

        Thread producer = new Thread(new Producer(store));
        Thread consumer = new Thread(new Consumer(store));

        producer.start();
        consumer.start();
    }
}
