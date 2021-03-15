package javaThreads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Parking {
    public static void main(String[] args) {
        ParkingSpace specialBlackCar = new ParkingSpace();
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
        new Thread(() -> {
            for (int i = 1; i < 16; i++) {
                try {
                    queue.offer("Car " + " A1" + i);
                    System.out.println("The Car with  A1" + i + "  took a place in the parking ");
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 1; i < 8; i++) {
                    queue.offer("Car " + " Z0" + i);
                    System.out.println("The Car with number  Z0" + i + "  took a place in the parking ");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("----- > The" + queue.poll() + " left the parking");
                    TimeUnit.SECONDS.sleep(3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        try {
            TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 12);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Sorry, there are no free parking spaces!  " + queue);

        new Thread(() -> {
            try {
                for (int i = 9; i < 10; i++) {
                    boolean flag = queue.offer("The Special Car with number XX0" + i);
                    System.out.println("<----------------> The Special Car with number XX0" + i + " added " + flag);
                    if (flag == false) {
                        specialBlackCar.waitUntilAParkingSpaceBecomesAvailable();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        try {
            TimeUnit.MILLISECONDS.sleep(37);
            specialBlackCar.leaveTheParking();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The availability of parking spaces (now) is:  " + queue);
    }
}