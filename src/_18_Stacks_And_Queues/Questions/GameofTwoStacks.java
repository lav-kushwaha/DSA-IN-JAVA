package _18_Stacks_And_Queues.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class GameofTwoStacks {

    // Main method to initiate the game and handle multiple test cases
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Create a scanner object for input
        int n = sc.nextInt(); // Read the number of test cases

        for (int i = 1; i <= n; i++) { // Loop through each test case
            int s = sc.nextInt(); // Read the size of the first stack
            int s1 = sc.nextInt(); // Read the size of the second stack
            int Maxsum = sc.nextInt(); // Read the maximum allowed sum

            int[] arr1 = new int[s]; // Initialize the first stack array
            int[] arr2 = new int[s1]; // Initialize the second stack array

            for (int j = 0; j < s; j++) { // Fill the first stack array
                arr1[j] = sc.nextInt();
            }

            for (int j = 0; j < s1; j++) { // Fill the second stack array
                arr2[j] = sc.nextInt();
            }

            // Print the result for the current test case
            System.out.println(TwoStacks(arr1, arr2, Maxsum));
        }

        sc.close(); // Close the scanner
    }

    // Method to initiate the recursive function and adjust the result by subtracting 1
    public static int TwoStacks(int[] a, int[] b, int Maxsum) {
        return TwoStacks(a, b, Maxsum, 0, 0) - 1; // Subtract 1 to get the correct count
    }

    // Recursive method to determine the maximum count of elements that can be taken from the two stacks without exceeding Maxsum
    private static int TwoStacks(int[] a, int[] b, int Maxsum, int sum, int count) {
        if (sum > Maxsum) { // If the current sum exceeds Maxsum, return the current count
            return count;
        }

        if (a.length == 0 || b.length == 0) { // If either stack is empty, return the current count
            return count;
        }

        // Recursively call the method by taking the first element of the first stack
        int ans1 = TwoStacks(Arrays.copyOfRange(a, 1, a.length), b, Maxsum, sum + a[0], count + 1);

        // Recursively call the method by taking the first element of the second stack
        int ans2 = TwoStacks(a, Arrays.copyOfRange(b, 1, b.length), Maxsum, sum + b[0], count + 1);

        // Return the maximum count from both recursive calls
        return Math.max(ans1, ans2);
    }
}

/*
The program handles multiple test cases to determine the maximum number of elements that can be taken from two stacks without exceeding a specified sum.
It uses a recursive approach to explore all possible combinations of taking elements from the two stacks.
The result is adjusted to account for the initial call setup before being printed for each test case.
 */