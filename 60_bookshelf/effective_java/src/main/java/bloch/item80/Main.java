package bloch.item80;
//Prefer executors, tasks, and streams to threads

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static void main() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Runnable myRunnable = () -> {
            for(int x=0; x < 10; x++) {
                int wait = ThreadLocalRandom.current().nextInt(1000);
                System.out.println(Thread.currentThread().getName() + " I have a " + x + " for you - and wait for " + wait + " ms");

                try {
                    Thread.sleep(wait);
                } catch (InterruptedException ie) {
                    System.out.println("Wow! Somebody interrupted me!");
                }
            }
        };

        executorService.submit(myRunnable);
        executorService.submit(myRunnable);

        executorService.shutdown();
    }
}
