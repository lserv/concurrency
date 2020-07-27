package io.lenur.concurrency.multithreading.deadlock.demo1;

class ThreadSecond extends Thread {
    private final Object object1;
    private final Object object2;

    public ThreadSecond(
            String name,
            Object object1,
            Object object2
    ) {
        super(name);
        this.object1 = object1;
        this.object2 = object2;
    }

    @Override
    public void run() {
        synchronized (object2) {
            System.out.println(getName() + ": Holding lock 2...");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(getName() + ": Waiting for lock 1...");

            synchronized (object1) {
                System.out.println(getName() + ": Holding lock 2 & 1...");
            }
        }
    }
}