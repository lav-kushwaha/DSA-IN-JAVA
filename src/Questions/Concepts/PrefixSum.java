package Questions.Concepts;
//prefix sum
public class PrefixSum {

    public static int[] prefixSum(int[] arr) {
        // Create a new array to store prefix sums
        int[] prefixSumArr = new int[arr.length];

        // Initialize the first element of the prefix sum array
        prefixSumArr[0] = arr[0];

        // Loop through the array to calculate prefix sums
        for (int i = 1; i < arr.length; i++) {
            prefixSumArr[i] = prefixSumArr[i - 1] + arr[i];
        }
        return prefixSumArr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int[] result = prefixSum(arr);

        // Print the original array
        System.out.print("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();

        // Print the prefix sum array
        System.out.print("Prefix Sum Array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
