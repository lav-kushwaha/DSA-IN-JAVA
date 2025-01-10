package Questions.Questions;

import java.util.*;

//https://leetcode.com/problems/word-subsets/description/
//916. Word Subsets

class wordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        
        int[] freq2 = new int[26];
        for (String word : words2) {
            int[] temp = new int[26];
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
                freq2[ch - 'a'] = Math.max(freq2[ch - 'a'], temp[ch - 'a']);
            }
        }
        
        for (String word : words1) {
            int[] temp = new int[26];
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
            }
            
            if (isSubset(freq2, temp)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean isSubset(int[] freq2, int[] temp) {
        for (int i = 0; i < 26; i++) {
            if (temp[i] < freq2[i]) {
                return false; 
            }
        }
        return true;
    }
}