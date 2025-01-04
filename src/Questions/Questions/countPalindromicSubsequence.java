package Questions.Questions;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/
//1930. Unique Length-3 Palindromic Subsequences
class countPalindromicSubsequence {
    public int countPalindromicSubsequence(String s) {
        // find unique chars
        HashMap<Character,Integer> firstOcc = new HashMap<Character,Integer>();
        HashMap<Character,Integer> lastOcc = new HashMap<Character,Integer>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(!firstOcc.containsKey(ch)){
                firstOcc.put(ch,i);
            }
            lastOcc.put(ch,i);
        }

        int count=0;
        for(char ch : firstOcc.keySet()){
            int first=firstOcc.get(ch);
            int last = lastOcc.get(ch);
            if(first == last) continue;
            HashSet<Character> set1 = new HashSet<>();
            for(int i=first+1;i<last;i++){
                set1.add(s.charAt(i));
            }
            count += set1.size();
        }
        return count;
    }
}