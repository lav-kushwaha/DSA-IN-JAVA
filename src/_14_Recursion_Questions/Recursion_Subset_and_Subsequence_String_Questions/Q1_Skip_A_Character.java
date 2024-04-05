package _14_Recursion_Questions.Recursion_Subset_and_Subsequence_String_Questions;

public class Q1_Skip_A_Character {
    public static void main(String[] args) {

        //Note : Method 1 and method 2 is same the only diff is in method 2 we have return p and in method 1 we have printed p.
       //Method -1 : Without return type passed "" as an argument and ans printed in func body.
         Skip("","baachda");

         //Method -2 : With Return Type and passed "" as an argument.
        System.out.println(Skip2("","baachda"));

        //Method 3 : With Return Type and added ch with skip().
          System.out.println(Skip3("baachda"));
    }

    //Method 1 : printed p in function body.
    static void Skip(String p,String up){
        if(up.isEmpty()){
            //this p is the answer
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

    //Method 2 : return p, so, it will return the same value to all the above function calls.
    static String Skip2(String p,String up){
        if(up.isEmpty()){
      //This p is the answer.
            return p;
        }

        char ch = up.charAt(0);

        if(ch == 'a'){
            return Skip2(p,up.substring(1));
        }
        else {
            return Skip2(p+ch,up.substring(1));
        }
    }

    //Method 3 : created ch variable in function.
    static String Skip3(String up){
        if(up.isEmpty()){
            return " ";
        }
        char ch = up.charAt(0);

        if(ch == 'a'){
            return Skip3(up.substring(1));
        }
        else {
            return ch+Skip3(up.substring(1));
        }
    }
}
