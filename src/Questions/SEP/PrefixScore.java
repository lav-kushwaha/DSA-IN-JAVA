package Questions.SEP;

import java.util.*;

public class PrefixScore {
    
    public static int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int totalScore = 0;
            
            for (int prefixLength = 1; prefixLength <= word.length(); prefixLength++) {
                String prefix = word.substring(0, prefixLength);
                totalScore += countWordsWithPrefix(words, prefix);
            }
            result[i] = totalScore;
        }
        
        return result;
    }
    
    private static int countWordsWithPrefix(String[] words, String prefix) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(prefix)) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        String[] words1 = {"abc", "ab", "bc", "b"};
        System.out.println(Arrays.toString(sumPrefixScores(words1)));  // Output: [5, 4, 3, 2]
    }
}
