package a_exam;

public class task_1_3_SieveOfEratosthenes {

    public static int[] primes(int n) {
        if (n < 2) {
            return new int[0];
        }

        int base = (int) Math.sqrt(n);

        boolean[] composites = new boolean[n + 1];

        for (int i = 2; i <= base; i++) {
            if (!composites[i]) {
                for (int j = i * i; j <= n; j += i) {
                    composites[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!composites[i]) {
                count++;
            }
        }

        int[] primesInt = new int[count];
        int index = 0;

        for (int i = 2; i <= n; i++) {
            if (!composites[i]) {
                primesInt[index] = i;
                index++;
            }
        }

        return primesInt;
    }
}