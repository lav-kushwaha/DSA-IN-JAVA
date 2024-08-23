package _27_RadixSort;

import java.util.Arrays;

public class RadixSort {

    // Function to get the maximum value in the array
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // A function to perform counting sort based on the digit represented by exp
    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // there are 10 possible digits (0-9)

        // Initialize count array as 0
        Arrays.fill(count, 0);

        // Store the count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so that it now contains the actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the output array to arr[], so that arr now contains sorted numbers according to the current digit
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // The main function to implement Radix Sort
    public static void radixSort(int[] arr) {
        // Find the maximum number to know the number of digits
        int max = getMax(arr);

        // Perform counting sort for every digit.
        // Instead of passing the digit number, exp is passed.
        // exp is 10^i where i is the current digit number.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
