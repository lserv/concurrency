package io.lenur.concurrency.multithreading.lock.conditional.demo1;

public class Application {
    public static void main(String[] args) {
        final Store store = new Store();
        final Thread producer = new Thread(new Producer(store));
        final Thread consumer = new Thread(new Consumer(store));

        producer.start();
        consumer.start();
    }
}
