package io.lenur.concurrency.multithreading.deadlock;

public class Demo2 {
    private final String first = "First";
    private final String second = "Second";

    private Thread thread1 = new Thread(() -> {
        while (true) {
            synchronized (first) {
                synchronized (second) {
                    System.out.println(String.format("%s - %s", first, second));
                }
            }
        }
    });

    private Thread thread2 = new Thread(() -> {
        while (true) {
            synchronized (second) {
                synchronized (first) {
                    System.out.println(String.format("%s - %s", second, first));
                }
            }
        }
    });

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        demo2.thread1.start();
        demo2.thread2.start();
    }
}
