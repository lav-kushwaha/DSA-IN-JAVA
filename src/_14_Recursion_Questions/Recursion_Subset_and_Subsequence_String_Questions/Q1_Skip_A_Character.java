package _14_Recursion_Questions.Recursion_Subset_and_Subsequence_String_Questions;

public class Q1_Skip_A_Character {
    public static void main(String[] args) {
        Skip("","baaccluvaa");
        String ans = Skip("baaccluvaa");
        System.out.println(ans);
    }
    static void Skip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if(ch == 'a'){
           Skip(p,up.substring(1));
        }
        else {
           Skip(p+ch,up.substring(1));
        }
    }

    static String  Skip(String up){
        if(up.isEmpty()){
            return " ";
        }

        char ch = up.charAt(0);

        if(ch == 'a'){
            return Skip(up.substring(1));
        }
        else {
            return ch+Skip(up.substring(1));
        }
    }
}
