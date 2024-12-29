package Questions.Questions;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description/
//1639. Number of Ways to Form a Target String Given a Dictionary
class numWays {
    private int MOD = (int) 1e9+7;
    public int numWays(String[] words, String target) {
        if(target.length() > words[0].length()){
            return 0;
        }

        long[][] dp = new long[target.length()][words[0].length()];

        for(long[] it : dp){
            Arrays.fill(it,-1);
        }

        return (int) helper(words, target, 0, 0, dp) % MOD;
    }

    private long helper(String[] words, String target, int i, int j, long[][] dp){
        if(i == target.length()){
            return 1;
        }
        if(j == words[0].length()){
            return 0;
        }

        int remTarget = target.length() - i;
        int remWord = words[0].length() - j;

        if(remTarget > remWord){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        long val = helper(words, target, i, j+1, dp);

        for(int k = 0;k < words.length;k++){
            if(words[k].charAt(j) == target.charAt(i)){
                val += helper(words, target, i+1, j+1, dp);
            }
        }

        return dp[i][j] = (val % MOD);
    }
}