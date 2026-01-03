package threads;

import java.util.concurrent.TimeUnit;

public class Basics {

    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean getStopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!getStopRequested()) {
//                System.out.println("I am counting " + i);
                i++;
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
//        stopRequested = true;
        requestStop();
    }
}