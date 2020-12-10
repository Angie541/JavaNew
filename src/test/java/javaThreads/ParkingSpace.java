package javaThreads;

public class ParkingSpace {
    public synchronized void waitUntilAParkingSpaceBecomesAvailable() {
        try {
            System.out.println("-------------------The Special Car with  number  XX09  is waiting... ");
            this.wait(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void leaveTheParking() {
        System.out.println("---------------->The Special Car is leaving ... ");
        this.notify();
    }
}