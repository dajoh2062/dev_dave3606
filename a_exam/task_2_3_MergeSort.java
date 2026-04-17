package a_exam;

class MergeSort {
    public static int[] mergeSort(int[] numbers) {
        if (numbers.length <= 1) {
            return numbers;
        }

        int mid = numbers.length / 2;

        int[] left = new int[mid];
        int[] right = new int[numbers.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = numbers[i];
        }

        for (int i = mid; i < numbers.length; i++) {
            right[i - mid] = numbers[i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return mergeHalves(left, right);
    }

    private static int[] mergeHalves(int[] L, int[] R) {
        int totalLength = L.length + R.length;
        int[] merged = new int[totalLength];

        int i = 0;
        int j = 0; 
        int k = 0; 

        while (i < L.length && j < R.length) {
            if (L[i] < R[j]) {
                merged[k] = L[i];
                i++;
            } else {
                merged[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < L.length) {
            merged[k] = L[i];
            i++;
            k++;
        }

        while (j < R.length) {
            merged[k] = R[j];
            j++;
            k++;
        }

        return merged;
    }
}

public class task_2_3_MergeSort {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 3, 7};

        int[] sorted = MergeSort.mergeSort(numbers);

        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
}