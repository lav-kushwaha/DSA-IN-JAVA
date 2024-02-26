import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Example 1 :
        int[] arr1 = {1, 2, 3, 4, 5};
        int N1 = 5;
        int K1 = 3;
        reverseInGroups(arr1, N1, K1);
        for (int value : arr1) {
            System.out.print(value + " ");// Output: 3 2 1 5 4
        }
        // Example 2:
        //int[] arr2 = {5, 6, 8, 9};
        //int N2 = 4;
        //int K2 = 3;
        //reverseInGroups(arr2, N2, K2);
        //for (int value : arr1) {
        //System.out.print(value + " "); // Output: 8 6 5 9
        // }
    }
    public static void reverseInGroups(int[] arr, int N, int K) {
        int i = 0;
        // Iterate through the array in groups of size K
        while (i < N) {
            // Find the ending index of the current group.
            int endIndex = (i + K - 1 < N - 1) ? i + K - 1 : N - 1;
            // Reverse the current group.
            reverseArray(arr, i, endIndex);
            // Move to the next group.
            i += K;
        }
    }
    // Helper function to reverse a sub-array in-place.
    static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            // Swap elements at start and end indices.
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            // Move indices towards the center.
            start++;
            end--;
        }
    }
}
