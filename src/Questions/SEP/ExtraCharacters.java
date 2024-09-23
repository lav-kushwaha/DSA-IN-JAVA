package Questions.SEP;
import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/extra-characters-in-a-string/description/
//2707. Extra Characters in a String

public class ExtraCharacters {
    int dp[] = new int[50];
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Arrays.fill(dp, -1);
        HashSet<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        return helper(s, dictionarySet, 0);
    }

    public int helper(String s, HashSet<String> dictionary, int index) {
        if (index == s.length()) return 0;

        // If the result for the current index is already computed, return it (memoization)
        if (dp[index] != -1) return dp[index];
        StringBuilder sb = new StringBuilder();
        int minExtraChar = Integer.MAX_VALUE;
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            int extraChar = 0;
            if (!dictionary.contains(sb.toString())) {
                extraChar = sb.length();
            }
            int curExtra = helper(s, dictionary, i + 1);
            minExtraChar = Math.min(minExtraChar, extraChar + curExtra);
        }

        // Store the result in dp array to avoid recomputation
        return dp[index] = minExtraChar;
    }

    public static void main(String[] args) {
        ExtraCharacters solution = new ExtraCharacters();
        String s1 = "applespie";
        String[] dictionary1 = {"apple", "pie"};
        System.out.println("Minimum extra characters (Test 1): " + solution.minExtraChar(s1, dictionary1));
    }
}
