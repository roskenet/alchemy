package de.felixroske.threadsplayground;

public class WorkerThing implements Runnable {

    private final String threadName;

    public WorkerThing(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Hello, we are doing something!");

        for(int x=0; x < 60; x++) {
            System.out.println("We are at: " + threadName + " and count " + x);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
