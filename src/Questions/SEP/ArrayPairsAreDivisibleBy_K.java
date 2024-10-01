package Questions.SEP;

//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
//1497. Check If Array Pairs Are Divisible by k

public class ArrayPairsAreDivisibleBy_K {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];

        for (int num : arr) {
            int remainder = ((num % k) + k) % k;//handle negative remainders.
            remainderCount[remainder]++;
        }

        for (int i = 1; i < k; i++) {
            if (remainderCount[i] != remainderCount[k - i]) {
                return false;
            }
        }

        return remainderCount[0] % 2 == 0;
    }

    public static void main(String[] args) {
        ArrayPairsAreDivisibleBy_K solution = new ArrayPairsAreDivisibleBy_K();
        int[] arr1 = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k1 = 5;
        System.out.println(solution.canArrange(arr1, k1)); // Output: true
    }
}
