package Questions.Questions;

//https://leetcode.com/problems/construct-k-palindrome-strings/description/
//1400. Construct K Palindrome Strings
class canConstruct {
    public boolean canConstruct(String s, int k) {
        int n = s.length();

        if(n < k) {
            return false;
        }

        if(n == k) {
            return true;
        }

        int[] vec = new int[26];
        for(char ch : s.toCharArray()) {
            vec[ch-'a']++;
        }

        int oddFreqCharCount = 0;

        for(int i = 0; i < 26; i++) {
            if(vec[i]%2 != 0) {
                oddFreqCharCount++;
            }
        }

        return oddFreqCharCount <= k;
    }
}