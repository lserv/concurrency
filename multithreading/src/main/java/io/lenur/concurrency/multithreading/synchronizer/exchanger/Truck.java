package io.lenur.concurrency.multithreading.synchronizer.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Truck implements Runnable {
    private final Exchanger<String> exchanger;
    private final int number;
    private final String dep;
    private final String destination;
    private final String[] parcels;

    public Truck(
            int number,
            String departure,
            String destination,
            String[] parcels,
            Exchanger<String> exchanger
    ) {
        this.number = number;
        this.exchanger = exchanger;
        this.dep = departure;
        this.destination = destination;
        this.parcels = parcels;
    }

    @Override
    public void run() {
        try {
            System.out.printf("To the truck №%d loaded: %s и %s.\n", number, parcels[0], parcels[1]);
            System.out.printf("The truck №%d moved from point %s to point %s.\n", number, dep, destination);
            TimeUnit.SECONDS.sleep(1000 + (long) (Math.random() * 5000));
            System.out.printf("The truck №%d has come to the point Е.\n", number);
            parcels[1] = exchanger.exchange(parcels[1]);//when we perform exchange() a thread blocks and waits
            //while another thread calls exchange(), after that there will be an exchange of packages
            System.out.printf("Into the truck №%d placed parcel for point %s.\n", number, destination);
            TimeUnit.SECONDS.sleep(1000);
            System.out.printf("The truck №%d has come into %s and delivered: %s и %s.\n", number, destination, parcels[0], parcels[1]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}