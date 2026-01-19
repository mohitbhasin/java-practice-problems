package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MakingMethodThreadSafe {
    public static void main(String[] args) {
        Counter counter = new Counter();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=1; i<=100000; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    counter.syncIncrement();
                    counter.nonSyncIncrement();
                }
            };
            executorService.submit(task);
        }
        // shutdown() - (orderly shutdown) tells executor service to stop accepting new tasks.
        executorService.shutdown();

        try {
            // ExecutorService.awaitTermination() will make the current thread wait,
            // util one of the following is met:
            // - All the submitted tasks have completed after shutdown request.
            // - The specified time has elapsed.
            if(executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Synchronized Increment: "+counter.syncCount);
                System.out.println("Non-Synchronized Increment: "+counter.nonSyncCount);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Counter {
    int syncCount;
    int nonSyncCount;

    public synchronized void syncIncrement() {
        this.syncCount++;
    }

    public void nonSyncIncrement() {
        this.nonSyncCount++;
    }
}
