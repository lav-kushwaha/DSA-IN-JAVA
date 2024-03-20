package _14_Recursion_Questions;

public class Q2_FactorialUsingRecursion {
    public static void main(String[] args) {
       int ans =factorial(5);
        System.out.println(ans);

    }
    static int factorial(int n){
        //base condition
        if(n<=1) {
            return 1;
        }
        //This "n * factorial(n - 1)" is like - 5*factorial(5-1)=>4*factorial(4-1)
        return n * factorial(n - 1);
    }

}
