package io.lenur.concurrency.multithreading.lock.readwrite;

public class AddThread implements Runnable {
    private final ThreadSafeArrayList<String> list;
    private final String value;

    public AddThread(ThreadSafeArrayList<String> list, String value) {
        this.list = list;
        this.value = value;
    }

    @Override
    public void run() {
        list.set(value);
    }
}
