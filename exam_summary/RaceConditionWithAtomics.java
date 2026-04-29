package exam_summary;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionWithAtomics {
    // Usuing AtomicInteger instead of int.
    private static final AtomicInteger sharedCounter = new AtomicInteger();

    public static void run(int threadIndex) {
        int localCounter = 0;
        while (localCounter < 1_000_000) {

            // Still get racecondition because operation is not 1 step (atomic).
            // Should do sharedCounter.getAndIncrement(); or sharedCounter.IncrementAndGet();
            int currentValue = sharedCounter.get();
            sharedCounter.set(currentValue + 1);
            localCounter++;
        }
        System.out.printf("Thread %d finished; local counter is %d%n",
            threadIndex, localCounter);
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            final int threadIndex = i;
            Thread thread = new Thread(() -> run(threadIndex));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.printf("Shared counter is %d%n", sharedCounter.get());
    }
}
