package Questions.Questions;

//https://leetcode.com/problems/minimum-length-of-string-after-operations/description/
//3223. Minimum Length of String After Operations
class minimumLength {
    public int minimumLength(String s) {
        int n = s.length();

        int[] freq = new int[26];
        int deleted = 0;

        for(int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a'] += 1;

            if(freq[s.charAt(i) -'a'] == 3) {
                freq[s.charAt(i) - 'a'] -= 2;
                deleted += 2;
            }
        }
        return n - deleted;
    }
}