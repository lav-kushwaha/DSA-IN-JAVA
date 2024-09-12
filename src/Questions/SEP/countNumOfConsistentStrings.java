package Questions.SEP;

import java.util.HashSet;
import java.util.Set;

public class countNumOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();

        for (char ch : allowed.toCharArray()) {
            set.add(ch);
        }
        
        int count = 0;

        for (String word : words) {
            boolean isConsistent = true;

            for (char ch : word.toCharArray()) {
                if (!set.contains(ch)) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) {
                count++;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        countNumOfConsistentStrings counter = new countNumOfConsistentStrings();
        
        String allowed = "abc";
        String[] words = {"a", "b", "c", "ab", "ac", "bc", "abc", "abcd"};
        
        int result = counter.countConsistentStrings(allowed, words);
        System.out.println("Number of consistent strings: " + result);
    }
}
