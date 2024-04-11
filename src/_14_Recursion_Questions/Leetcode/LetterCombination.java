package _14_Recursion_Questions.Leetcode;

import java.util.ArrayList;
import java.util.List;
//By K.k
public class LetterCombination {
    public static void main(String[] args) {
        pad("","12");
        System.out.println(letterCombinations("","12"));
        System.out.println(padCount("","12"));
    }

    //print letter combinations.
    static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }

    }

    //return letter combinations as a list.
    static List<String> letterCombinations(String p,String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digits = up.charAt(0) - '0'; // this will convert '2' into 2

        List<String> ans = new ArrayList<>();

        for(int i=(digits-1)*3;i<digits*3;i++){
            char ch = (char) ('a'+ i);
           ans.addAll( letterCombinations(p+ch,up.substring(1)));
        }
        return ans;
    }

    //Count of letter combinations.
    static int padCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            count = count + padCount(p + ch, up.substring(1));
        }
        return count;
    }

}
