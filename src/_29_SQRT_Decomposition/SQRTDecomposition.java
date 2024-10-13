package _29_SQRT_Decomposition;

public class SQRTDecomposition {
    // Function to perform a sum query on the range [l, r]
    public static int query(int[] blocks, int[] arr, int l, int r, int sqrt) {
        int ans = 0;

        // Left part: elements before the start of the first full block
        while (l <= r && l % sqrt != 0) {
            ans += arr[l];
            l++;
        }

        // Middle part: full blocks within the range
        while (l + sqrt - 1 <= r) {
            ans += blocks[l / sqrt];
            l += sqrt;
        }

        // Right part: elements after the last full block
        while (l <= r) {
            ans += arr[l];
            l++;
        }

        return ans;
    }

    // Function to update an element at index i to new value val
    public static void update(int[] blocks, int[] arr, int i, int val, int sqrt) {
        int block_id = i / sqrt; // Find the block index
        blocks[block_id] += (val - arr[i]); // Update the block sum
        arr[i] = val; // Update the array element
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;

        // Calculate block size
        int sqrt = (int) Math.sqrt(n);  // size of each block

        // Determine the number of blocks
        int blockCount = (n + sqrt - 1) / sqrt;

        // Initialize block array
        int[] blocks = new int[blockCount];

        // Build blocks array with sums of elements in each block
        for (int i = 0; i < n; i++) {
            blocks[i / sqrt] += arr[i];
        }

        System.out.println(query(blocks, arr, 2, 7, sqrt)); // Expected:sum from index 2 to 7

        // Example update
        update(blocks, arr, 3, 10, sqrt); // Update index 3 to value 10
        System.out.println(query(blocks, arr, 2, 7, sqrt)); // Query again to see updated sum
    }
}
