package io.lenur.concurrency.multithreading.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

public class Application {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        new Philosopher(semaphore, "Socrates").start();
        new Philosopher(semaphore, "Plato").start();
        new Philosopher(semaphore, "Aristotle").start();
        new Philosopher(semaphore, "Thales").start();
        new Philosopher(semaphore, "Pythagoras").start();
    }
}
