package _14_Recursion_Questions;

public class Q4_SumOfDigits {
    public static void main(String[] args) {
        int n = 1342;
//      int ans = DigitsSum(n);
        int ans = DigitsSumUsingRecursion(n);
        System.out.println(ans);
    }

    //simple way to sum of digits.
//    static int DigitsSum(int n){
//        int sum = 0;
//        while(n!=0){
//            int digit = n%10;
//            sum+=digit;
//            n/=10;
//        }
//        return sum;
//    }

    //using recursion for sum of digits.
    static int DigitsSumUsingRecursion(int n){
        if(n==0){
            return 0;
        }
        return (n%10)+DigitsSumUsingRecursion(n/10);
    }
}
