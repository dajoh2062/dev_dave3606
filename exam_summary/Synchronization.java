package exam_summary;

import java.util.ArrayList;
import java.util.List;

public class Synchronization {
    private int sharedCounter = 0;
    private final Object lock = new Object();

    public void run(int threadIndex) {
        int localCounter = 0;
        for (int j = 0; j < 1_000_000; j++) {
            // Every operation in sync-block is atomic
            synchronized (lock) {
                sharedCounter++;
            }
            localCounter++;
        }
        System.out.printf("Thread %d finished; local counter is %d%n",
            threadIndex, localCounter);
    }

    public int getSharedCounter() {
        synchronized (lock) {
            return sharedCounter;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        Synchronization synchronization = new Synchronization();

        for (int i = 0; i < 2; i++) {
            final int threadIndex = i;
            Thread thread = new Thread(() -> synchronization.run(threadIndex));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.printf("Shared counter is %d%n", synchronization.getSharedCounter());
    }
}
