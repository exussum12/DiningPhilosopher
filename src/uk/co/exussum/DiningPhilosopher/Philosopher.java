package uk.co.exussum.DiningPhilosopher;

public class Philosopher extends Thread {
    private final Fork left;
    private final Fork right;
    private final int philosopherNumber;

    private int eatTime = 1000;
    private int thinkingTime = 2000;

    Philosopher(int philosopherNumber, Fork left, Fork right) {
        this.philosopherNumber = philosopherNumber;
        this.left = left;
        this.right = right;
    }

    private void eat()
    {
        if (!left.isBeingUsed() && !right.isBeingUsed()) {
            left.take();
            right.take();
            try {
                System.out.println("Philosopher " + philosopherNumber + " Starting to eat");
                Thread.sleep(eatTime);
            } catch (Exception e) {
                System.out.println("Philosopher " + philosopherNumber + " interrupted eating");
            }

            right.putDown();
            left.putDown();
        }

        think(thinkingTime);
    }

    private void think(int thinkingTime)
    {
        try {
            System.out.println("Philosopher " + philosopherNumber + " Starting to think");
            Thread.sleep(thinkingTime);
        } catch (Exception e) {
            System.out.println("Philosopher " + philosopherNumber + " interrupted thinking");
        }
    }

    public void run()
    {
        while (true) {
            eat();
        }
    }
}
