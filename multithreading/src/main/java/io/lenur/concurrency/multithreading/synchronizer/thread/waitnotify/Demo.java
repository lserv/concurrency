package io.lenur.concurrency.multithreading.synchronizer.thread.waitnotify;

public class Demo {
    public static void main(String[] args) {
        Data data = new Data();
        Thread threadSender = new Thread(new Sender(data));
        Thread threadReceiver = new Thread(new Receiver(data));

        threadSender.start();
        threadReceiver.start();
    }
}
