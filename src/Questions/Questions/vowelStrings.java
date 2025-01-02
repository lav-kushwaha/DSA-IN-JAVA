package Questions.Questions;

//https://leetcode.com/problems/count-vowel-strings-in-ranges/description/
//2559. Count Vowel Strings in Ranges
class vowelStrings {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int N = words.length;
        int Q = queries.length;
        int[] result = new int[Q];
        int[] cumSum = new int[N];
        
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                sum++;
            }
            cumSum[i] = sum;
        }
        
        for (int i = 0; i < Q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = cumSum[r] - (l > 0 ? cumSum[l - 1] : 0);
        }
        
        return result;
    }
    
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}