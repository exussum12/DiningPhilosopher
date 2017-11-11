package uk.co.exussum.DiningPhilosopher;

public class Table {
    public static void main(String[] args)
    {
        int numberOfPhilosophers = 5;
        Fork[] forks = new Fork[numberOfPhilosophers + 1];
        for(int i = 0; i <= numberOfPhilosophers; i++) {
            forks[i] = new Fork();
        }

        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        for (int i = 0; i < numberOfPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[i+1 % numberOfPhilosophers]);
            Thread thread = new Thread(philosophers[i]);
            thread.start();
        }
    }
}
