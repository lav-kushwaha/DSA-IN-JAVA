package Questions.SEP;
import java.util.*;

//https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description/
//2416. Sum of Prefix Scores of Strings

public class PrefixScore {

    //Brute force approaches
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

    //HashMaps approaches
    public static int[] sumPrefixScores02(String[] words) {
        Map<String, Integer> prefixCountMap = new HashMap<>();

        for (String word : words) {
            for (int prefixLength = 1; prefixLength <= word.length(); prefixLength++) {
                String prefix = word.substring(0, prefixLength);
                prefixCountMap.put(prefix, prefixCountMap.getOrDefault(prefix, 0) + 1);
            }
        }

        int[] result = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int totalScore = 0;

            for (int prefixLength = 1; prefixLength <= word.length(); prefixLength++) {
                String prefix = word.substring(0, prefixLength);
                totalScore += prefixCountMap.get(prefix);
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
