package a_exam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class ParallelPrimesFaster{
    public static int last;
    private static final AtomicInteger nextToCheck = new AtomicInteger(2);
    private static final AtomicInteger primeCount = new AtomicInteger(0);

    public static void run(){
        while(true){
            int n = nextToCheck.getAndIncrement();
            if (n > last){
                return;
            }
            if(isPrime(n)){
                primeCount.getAndIncrement();
            }
        }
    }

    private static boolean isPrime (int n){
        int root = (int) Math.sqrt(n);

        for (int d = 2; d <= root; d++){
            if (n % d == 0){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) throws InterruptedException {
        last = Integer.parseInt(args[0]);
        int parallelism = Integer.parseInt(args[1]);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i< parallelism; i+=1){
            Thread thread = new Thread(ParallelPrimesFaster::run);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads){
            thread.join();
        }

        System.out.println(primeCount.get());


    }

    

}