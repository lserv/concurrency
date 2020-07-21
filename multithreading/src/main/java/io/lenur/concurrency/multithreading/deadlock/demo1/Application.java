package io.lenur.concurrency.multithreading.deadlock.demo1;

public class Application {

    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        ThreadFirst threadFirst = new ThreadFirst("Threat 1", object1, object2);
        ThreadSecond threadSecond = new ThreadSecond("Threat 2", object1, object2);

        threadFirst.start();
        threadSecond.start();
    }
}
