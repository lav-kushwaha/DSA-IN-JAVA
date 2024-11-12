package Questions.Questions;

import java.util.Arrays;

//2601. Prime Subtraction Operation
//https://leetcode.com/problems/prime-subtraction-operation/description/
class primeSubOperation {
    boolean[] isPrime = new boolean[1000];

    // Sieve of Eratosthenes to mark prime numbers up to 1000
    void sieve() { // O(1)
        Arrays.fill(isPrime, true); // Initialize all values to true
        isPrime[0] = false; // 0 is not a prime number
        isPrime[1] = false; // 1 is not a prime number
        
        for (int i = 2; i * i < 1000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;

        sieve(); // Populates the isPrime array with prime indicators

        // Loop through the array from the second-last element to the start
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                continue;
            }

            // Find the largest prime `p` less than `nums[i]`
            for (int p = 2; p < nums[i]; p++) {
                if (!isPrime[p]) {
                    continue;
                }

                if (nums[i] - p < nums[i + 1]) {
                    nums[i] -= p;
                    break;
                }
            }

            // Check if the condition still holds; if not, return false
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }

        return true;
    }
}