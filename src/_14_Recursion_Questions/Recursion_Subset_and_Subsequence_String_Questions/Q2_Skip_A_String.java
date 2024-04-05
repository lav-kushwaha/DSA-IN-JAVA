package _14_Recursion_Questions.Recursion_Subset_and_Subsequence_String_Questions;

public class Q2_SkipStringFromChar {
    public static void main(String[] args) {
        //skip apple from this string
        System.out.println(Skip("ballapplecat"));

        //if not apple in the string then skip app form the string.
        System.out.println(Skip1("ballapplecat"));
    }

    //skip apple from the string
    static String Skip(String up){
        if(up.isEmpty()){
            return "";
        }

        char ch  = up.charAt(0);

        if(up.startsWith("apple")){
            return Skip(up.substring(5));
        }
        else{
            return up.charAt(0) + Skip(up.substring(1));
        }
    }

    //if not apple in the string then skip app form the string.
    static String Skip1(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch  = up.charAt(0);

        //if not apple in the string then skip app form the string.
        if(up.startsWith("app") && !up.startsWith("apple")){
            return Skip(up.substring(3));
        }
        else{
            return ch + Skip(up.substring(1));
        }
    }
}
