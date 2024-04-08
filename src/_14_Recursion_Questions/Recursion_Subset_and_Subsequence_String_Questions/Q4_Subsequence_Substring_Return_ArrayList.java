package _14_Recursion_Questions.Recursion_Subset_and_Subsequence_String_Questions;

import java.util.ArrayList;

public class Q4_Subsequence_Substring_Return_ArrayList {
    public static void main(String[] args) {
        System.out.println(Substring("","abc"));
    }

    static ArrayList<String> Substring(String p,String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = Substring(p+ch,up.substring(1));
        ArrayList<String> right = Substring(p,up.substring(1));

        left.addAll(right);

        return left;
    }
}
