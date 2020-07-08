package io.lenur.concurrency.multithreading.synchronizer.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        final Exchanger<String> exchanger = new Exchanger<>();
        String[] p1 = new String[]{"{parcel A->D}", "{parcel A->C}"};//Forming a cargo for the first truck
        String[] p2 = new String[]{"{parcel B->C}", "{parcel B->D}"};//Forming a cargo for the second truck

        Thread threadA = new Thread(new Truck(1, "A", "D", p1, exchanger));
        threadA.start();//Sending the first truck from A to D
        TimeUnit.MILLISECONDS.sleep(100);

        Thread threadB = new Thread(new Truck(2, "B", "C", p2, exchanger));
        threadB.start();//Sending the second truck from B to C
    }
}
