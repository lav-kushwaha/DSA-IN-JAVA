package _14_Recursion_Questions.Leetcode;

import java.util.ArrayList;
import java.util.List;

class Phonepad {

    public static List<String> letterCombinations(String digits) {
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

        List<String> result = letterCombinations("23");
        System.out.println(result);
    }
}