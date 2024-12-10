package Questions.Questions;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/description/
//2981. Find Longest Special Substring That Occurs Thrice I
//Approach (Brute Force - Try all possible substrings)
//T.C : O(n^3)
//S.C : O(n^2), total substrings
class maximumLength {
    public int maximumLength(String s) {
        int n = s.length();
        Map<String, Integer> mp = new HashMap<>(); // Map to store substring and its frequency

        for (int i = 0; i < n; i++) {
            StringBuilder curr = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (curr.length() == 0 || curr.charAt(curr.length() - 1) == s.charAt(j)) {
                    curr.append(s.charAt(j));
                    mp.put(curr.toString(), mp.getOrDefault(curr.toString(), 0) + 1);
                } else {
                    break;
                }
            }
        }

        int result = 0;
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            String str = entry.getKey();
            int count = entry.getValue();
            if (count >= 3 && str.length() > result) {
                result = str.length();
            }
        }

        return result == 0 ? -1 : result;
    }
}