package frc.robot;

public class Delay {

    long endTime;

    public Delay(long ms) {
        endTime = System.nanoTime() + 1000000 * ms;
    }

    public boolean isExpired() {
        return endTime < System.nanoTime();
    }
}