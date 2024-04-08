package _14_Recursion_Questions.Recursion_Subset_and_Subsequence_String_Questions;

public class Q3_SubSequence_Substring {
    public static void main(String[] args) {
        Substring(" ","abc");
    }
     static void Substring(String p,String up) {
        if(up.isEmpty()){
            System.out.print(p);
            return;
        }
        char ch = up.charAt(0);
        // char ch take it.
         Substring(p+ch,up.substring(1));
         //char ch ignore it.
         Substring(p,up.substring(1));

     }
}
