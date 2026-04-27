package a_exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;


public class ParallelPrimesFastest {
    private static int last;
    private static final AtomicInteger nextToCheck = new AtomicInteger(2);
    private static final AtomicInteger lowestInProgress = new AtomicInteger(2);
    private static final ConcurrentLinkedQueue<Integer> primes = new ConcurrentLinkedQueue<>();

    public static void run(){
        while (true){
            int n = nextToCheck.getAndIncrement();
            if(n> last){
                return;
            }

            boolean p = isPrime(n);
            while(lowestInProgress.getAcquire() != n){

            }
            if (p){
                primes.add(n);
            }
            lowestInProgress.setRelease(n+1);
            

        }

    }
    public static boolean isPrime(int n){
        int root = (int) Math.sqrt(n);
        int d = 1;

        for (int prime : primes){
            d = prime;
            if(prime>root)return true;
            else if(n % prime == 0)return false;
        }

        while(d < root){
            d++;
            if(n%d == 0)return false;
        }

        return true;


    }


    public static void main(String[] args) throws InterruptedException {
        last = Integer.parseInt(args[0]);
        int parallelism = Integer.parseInt(args[1]);
        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i < parallelism; i++){
            Thread thread = new Thread(ParallelPrimesFastest::run);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads){
            thread.join();
        }
        System.out.println(primes.size());
    }



}
