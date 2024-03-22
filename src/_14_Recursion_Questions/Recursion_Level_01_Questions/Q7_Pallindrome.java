package _14_Recursion_Questions.Recursion_Level_01_Questions;

public class Q7_Pallindrome {

    static int ReverseNum(int n){
        int digits = (int)Math.log10(n)+1;
        return helper(n,digits);
    }

    static int helper(int n, int digits){
        if(n%10==n){
            return n;
        }
        int rem = n%10;
        return rem*(int)(Math.pow(10,digits-1))+helper(n/10,digits-1);
    }

    static boolean Pallindrome(int n){
        return n == ReverseNum(n);
    }

    public static void main(String[] args) {
        System.out.println(Pallindrome(121));//true
    }
}
