package _14_Recursion_Questions.Recursion_Subset_and_Subsequence_String_Questions.String_Google_Amazon_Questions;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
//Q: Letter Combinations of a Phone Number.
//This question asked in Amazon, Microsoft,Facebook,Uber,Apple.

class Phonepad {

    public static List<String> letterCombinations(String digits) {
        //if digit string is empty, return empty arraylist []
        if (digits.isEmpty())
            return new ArrayList<>();
        return letterCombinations("", digits);
    }

    static List<String> letterCombinations(String p, String up) {
        String[] digitMap = {
                "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0' - 2;
        String letters = digitMap[digit];
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            ans.addAll(letterCombinations(p + ch, up.substring(1)));
        }
        return ans;
    }

    public static void main(String[] args) {

        List<String> result = letterCombinations("");
        System.out.println(result);
    }
}