package _14_Recursion_Questions.Leetcode;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
//Q: Letter Combinations of a Phone Number.
//This question asked in Amazon, Microsoft,Facebook,Uber,Apple.

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        System.out.println();
    }
    static List<String> letterCombinations(String p,String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digits = up.charAt(0) - '0';
        List<String> ans = new ArrayList<>();

        for(int i=(digits-1)*3;i<digits*3;i++){
            char ch = (char) ('a'+ i);
           ans.addAll( letterCombinations(p+ch,up.substring(1)));
        }
        return ans;
    }
}
