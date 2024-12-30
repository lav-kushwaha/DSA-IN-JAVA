package Questions.Questions;

//https://leetcode.com/problems/count-ways-to-build-good-strings/description/
//2466. Count Ways To Build Good Strings
class countGoodStrings {
    private int mod = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        if (zero > one) 
            return countGoodStrings(low, high, one, zero);

        int dp[] = new int[high + 1], res = 0;
        dp[0] = 1;

        for (int i = 1; i <= high; i++) {
            if (i >= zero)
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            if (i >= one)
                dp[i] = (dp[i] + dp[i - one]) % mod;
            if (i >= low)
                res = (res + dp[i]) % mod;
        }

        return res;
    }
}