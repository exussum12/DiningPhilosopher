package uk.co.exussum.DiningPhilosopher;

class Fork {
    private boolean used = false;

    boolean isBeingUsed()
    {
        return used;
    }

    synchronized void take()
    {
        this.used = true;
    }

    synchronized void putDown()
    {
        this.used = false;
    }
}
