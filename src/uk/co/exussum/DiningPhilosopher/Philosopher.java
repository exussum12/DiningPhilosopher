package uk.co.exussum.DiningPhilosopher;

public class Philosopher extends Thread {
    private final Fork left;
    private final Fork right;
    private final int philosopherNumber;

    private int eatTime = 1000;
    private int thinkingTime = 1000;

    private long totalThinkingTime = 0;
    private long totalEatingTime = 0;

    Philosopher(int philosopherNumber, Fork left, Fork right) {
        this.philosopherNumber = philosopherNumber;
        this.left = left;
        this.right = right;
    }

    private void eat()
    {
        long time;
        try {
            left.take();
            right.take();
            time = -System.currentTimeMillis();
            Thread.sleep(eatTime);
            totalEatingTime += time + System.currentTimeMillis();
        } catch (InterruptedException e) {
            System.out.println("Philosopher " + philosopherNumber + " interrupted eating");
        } catch (Exception e) {
            // Forks are being used, Continue to think
        } finally {
            right.putDown();
            left.putDown();
        }
    }

    private void think(int thinkingTime)
    {
        long time;
        try {

            time = -System.currentTimeMillis();
            Thread.sleep(thinkingTime);
            totalThinkingTime += time + System.currentTimeMillis();
        } catch (Exception e) {
            System.out.println("Philosopher " + philosopherNumber + " interrupted thinking");
        }
    }

    private void showTotals()
    {
        System.out.println(
                "Philosopher " + philosopherNumber + " total thinking " + totalThinkingTime + " Total eating " + totalEatingTime
        );
    }

    public void run()
    {
        while (true) {
            eat();
            think(thinkingTime);
            showTotals();
        }
    }
}
