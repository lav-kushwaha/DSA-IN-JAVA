package _14_Recursion_Questions.Recursion_Subset_and_Subsequence_String_Questions;

import java.util.ArrayList;

public class Q5_PrintAsciiValueof_Substring {
    public static void main(String[] args) {

//        char ch = 'a';
//        System.out.println(ch+0);//char converted into int here, 97 ans.
//        System.out.println((char)(ch+0)); // cast into char, ans is a.


        //calling function
//        SubsetsAscii("","abc");

        //Returning SubsetsAscii
        System.out.println(SubsetsAsciii("","ab"));

    }

     static void SubsetsAscii(String p, String up) {
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }

        char ch = up.charAt(0);

        SubsetsAscii(p+ch,up.substring(1));
        SubsetsAscii(p,up.substring(1));

        SubsetsAscii(p+(ch+0),up.substring(1));
    }

    static ArrayList<String> SubsetsAsciii(String p, String up) {
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> first = SubsetsAsciii(p+ch,up.substring(1));
        ArrayList<String> second = SubsetsAsciii(p,up.substring(1));
        ArrayList<String> third = SubsetsAsciii(p+(ch+0),up.substring(1));

        first.addAll(second);
        first.addAll(third);

        return first;
    }
}
