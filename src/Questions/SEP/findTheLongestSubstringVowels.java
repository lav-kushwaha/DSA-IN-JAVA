package Questions.SEP;
import java.util.HashMap;

//https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/?envType=daily-question&envId=2024-09-15
//1371. Find the Longest Substring Containing Vowels in Even Counts

public class findTheLongestSubstringVowels {
    //Approach-1 (Using map to store states)
    //T.C : O(n)
    //S.C : O(1)
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

    //Approach-2 (Using map to store states and using XOR to make states)
    //T.C : O(n)
    //S.C ; O(1)
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

    //Approach-3 (using Mask and Xor property)
    //T.C : O(n)
    //S.C : O(32) ~ O(1) - Maximum 2^5 states possible
    public int findTheLongestSubstring3(String s) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int mask = 0;
        mp.put(mask, -1);
        int maxL = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = 0;
            if (s.charAt(i) == 'a')      val = (1 << 0);
            else if (s.charAt(i) == 'e') val = (1 << 1);
            else if (s.charAt(i) == 'i') val = (1 << 2);
            else if (s.charAt(i) == 'o') val = (1 << 3);
            else if (s.charAt(i) == 'u') val = (1 << 4);

            mask ^= val; //xor nikala

            if (!mp.containsKey(mask)) //agar past me nahi dekha to map me daaldo
                mp.put(mask, i);

            maxL = Math.max(maxL, i - mp.get(mask)); //maxL nikaal lo
        }
        return maxL;
    }

    public static void main(String[] args) {
        findTheLongestSubstringVowels solution = new findTheLongestSubstringVowels();
        
        // Test cases
        String s1 = "eleetminicoworoep";
        System.out.println("Longest substring length (eleetminicoworoep): " + solution.findTheLongestSubstring(s1));  // Output: 13
     }
}
