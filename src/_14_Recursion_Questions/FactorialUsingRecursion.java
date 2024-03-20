package _14_Recursion_Questions;

public class FactorialUsingRec {
    public static void main(String[] args) {
       factorial(5);

    }
    static void factorial(int n){
        if(n==0){
            return;
        }
        System.out.println(n*n);
        factorial(n-1);
    }

}
