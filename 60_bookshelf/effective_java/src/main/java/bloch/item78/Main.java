package bloch.item78;
// Synchronize access to shared mutable data

import java.util.concurrent.TimeUnit;

// Broken! - How long would you expect this program to run?
// Must use synchronized methods
// or volatile?

public class Main {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested())
                i++;
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
