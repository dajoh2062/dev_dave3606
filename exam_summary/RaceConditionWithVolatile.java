package exam_summary;

import java.util.ArrayList;
import java.util.List;


public class RaceConditionWithVolatile {
    //volatile makes the read and write visible across threads, 
    // but it does not make the whole read-modify-write sequence atomic.
    private static volatile int sharedCounter = 0;

    public static void run(int threadIndex) {
        int localCounter = 0;
        for (int j = 0; j < 1_000_000; j++) {
            sharedCounter++;
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

        System.out.printf("Shared counter is %d%n", sharedCounter);
    }
}
