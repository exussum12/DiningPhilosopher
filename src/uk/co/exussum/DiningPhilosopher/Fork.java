package uk.co.exussum.DiningPhilosopher;

class Fork {
    private boolean used = false;

    synchronized void take() throws Exception
    {
        if (used) {
            throw new Exception("Currently in use");
        }
        used = true;
    }

    synchronized void putDown()
    {
        used = false;
    }
}
