package Recursion.Questions;

public class FibonacciNumber {
    static int Fibo(int n){
        //base condition.
        if(n<2){
            return n;
        }
        return Fibo(n-1)+Fibo(n-2);
    }
    public static void main(String[] args) {
        int ans = Fibo(4);
        System.out.println(ans);
    }


}
