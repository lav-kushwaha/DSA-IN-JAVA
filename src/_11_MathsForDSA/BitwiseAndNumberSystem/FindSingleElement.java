package _11_MathsForDSA.BitwiseAndNumberSystem;

public class FindSingleElement {
    public static int findSingle(int[] nums) {
        int result = 0; // This variable will store the single occurring number.

        // We iterate through each bit position in a number (assuming 32-bit integers).
        for (int i = 0; i < 32; i++) {
            int sum = 0; // This will store the sum of bits at position i across all numbers.

            // We go through each number in the array and count the bits at position i.
            for (int num : nums) {
                sum += (num >> i) & 1;
                // (num >> i) shifts the bits of num to the right by i positions.
                // The "& 1" operation isolates the bit at position i.
                // We add the isolated bit to the sum.
            }

            sum %= 3; // Taking the sum modulo 3 eliminates bits appearing in triplets.

            // Now, we set the corresponding bit in the 'result' using bitwise OR operation.
            // We shift the calculated sum by i positions and then set the bit in 'result'.
            result |= (sum << i);
        }

        return result; // The 'result' now holds the single occurring number.
    }
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 2};
        int singleElement = findSingle(arr);
        System.out.println("The element appearing only once is: " + singleElement);
    }
}
