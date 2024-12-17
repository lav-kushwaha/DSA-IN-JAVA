package Questions.Questions;

//Approach (Using pointers and frequency table)
//T.C : O(n)
//S.C : O(26)

//https://leetcode.com/problems/construct-string-with-repeat-limit/description/
//2182. Construct String With Repeat Limit
class repeatLimitedString {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26]; 
        
        for (char ch : s.toCharArray()) { 
            count[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        int i = 25;

        while (i >= 0) { 
            if (count[i] == 0) {
                i--;
                continue;
            }

            char ch = (char) ('a' + i); 
            int freq = Math.min(count[i], repeatLimit);
            for (int k = 0; k < freq; k++) {
                result.append(ch);
            }
            count[i] -= freq;

            if (count[i] > 0) {
                int j = i - 1;
                while (j >= 0 && count[j] == 0) { 
                    j--;
                }

                if (j < 0) {
                    break; 
                }

                result.append((char) ('a' + j)); 
                count[j]--;
            }
        }

        return result.toString();
    }
}

