package Questions.SEP;
import java.util.HashMap;

//https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/?envType=daily-question&envId=2024-09-15
//1371. Find the Longest Substring Containing Vowels in Even Counts

public class findTheLongestSubstringVowels {
    public int findTheLongestSubstring(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int[] vowelCount = new int[5]; // a, e, i, o, u
        
        String currState = "00000";
        map.put(currState, -1);
        
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a')      vowelCount[0] = (vowelCount[0] + 1) % 2;
            else if (s.charAt(i) == 'e') vowelCount[1] = (vowelCount[1] + 1) % 2;
            else if (s.charAt(i) == 'i') vowelCount[2] = (vowelCount[2] + 1) % 2;
            else if (s.charAt(i) == 'o') vowelCount[3] = (vowelCount[3] + 1) % 2;
            else if (s.charAt(i) == 'u') vowelCount[4] = (vowelCount[4] + 1) % 2;

            currState = "";
            for (int j = 0; j < 5; j++) {
                currState += vowelCount[j];
            }

            if (map.containsKey(currState)) {
                maxLength = Math.max(maxLength, i - map.get(currState));
            } else {
                map.put(currState, i);
            }
        }

        return maxLength;
    }

    //second approach using XOR
    public int findTheLongestSubstring2(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        int[] vowelCount = new int[5]; // a, e, i, o, u

        String currState = "00000";
        map.put(currState, -1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a')      vowelCount[0] = (vowelCount[0] ^ 1);
            else if (s.charAt(i) == 'e') vowelCount[1] = (vowelCount[1] ^ 1);
            else if (s.charAt(i) == 'i') vowelCount[2] = (vowelCount[2] ^ 1);
            else if (s.charAt(i) == 'o') vowelCount[3] = (vowelCount[3] ^ 1);
            else if (s.charAt(i) == 'u') vowelCount[4] = (vowelCount[4] ^ 1);

            currState = "";
            for (int j = 0; j < 5; j++) {
                currState += vowelCount[j];
            }

            if (map.containsKey(currState)) {
                maxLength = Math.max(maxLength, i - map.get(currState));
            } else {
                map.put(currState, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        findTheLongestSubstringVowels solution = new findTheLongestSubstringVowels();
        
        // Test cases
        String s1 = "eleetminicoworoep";
        System.out.println("Longest substring length (eleetminicoworoep): " + solution.findTheLongestSubstring(s1));  // Output: 13
     }
}
