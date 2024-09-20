package Questions.SEP;

//https://leetcode.com/problems/shortest-palindrome/description/
//214. Shortest Palindrome

// Approach : used the prefix-suffix matching approach in this solution. T.C: O(n).
//We can solve this problem using KMP to optimize the T.C from O(n²) to O(n).

class ShortestPalindrome {

    public static String shortestPalindrome(String s) {
        int length = s.length();
        String reversedString = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < length; i++) {
            // If the prefix of 's' matches the suffix of 'reversedString'
            if (s.substring(0, length - i).equals(reversedString.substring(i))) {
                return new StringBuilder(reversedString.substring(0, i)).append(s).toString();
            }
        }
        return "";
    }

    // Main method to test the function
    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();

        // Test cases
        String test1 = "aacecaaa";

        // Printing results for different inputs
        System.out.println("Shortest palindrome for '" + test1 + "': " + sp.shortestPalindrome(test1));
    }
}