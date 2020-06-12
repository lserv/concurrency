package io.lenur.concurrency.multithreading.counter;

public class Application {
    public static void main(String[] args) {
        Countable counter = new Counter();
//        Countable counter = new CounterAtomic();
        Thread threadCounter1 = new Thread(new ThreadCounter(counter, "Thread 1"));
        Thread threadCounter2 = new Thread(new ThreadCounter(counter, "Thread 2"));

        threadCounter1.start();
        threadCounter2.start();
    }
}
