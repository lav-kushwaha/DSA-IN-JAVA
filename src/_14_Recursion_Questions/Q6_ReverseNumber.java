package _14_Recursion_Questions;

public class Q6_ReverseNumber {

    //1st Method -
    //Reversing number without using recusion.
    static int ReverseNum(int n){
        int rev = 0;
        while(n!=0){
            int digit = n%10;
            rev = rev*10+digit;
            n/=10;
        }
        return rev;
    }

    //2nd Method -
    //Reversing number using recursion
    static int sum = 0;
    static void ReverseNumRec(int n){
        if(n==0){
            return;
        }
        int rem = n%10;
        sum = sum * 10 + rem;
        ReverseNumRec(n/10);
    }

    //Method-03 - Reversing number using helper function.
    static int ReverseNumRec2(int n){
       //sometimes you might need some aditional variables int the argument
        //in that case, make another function.
        int digits = (int)(Math.log10(n))+1;
        return helper(n,digits);
    }
    //helper function
     static int helper(int n, int digits) {
        //if n is single digits
        if(n%10==n){
            return n;
        }
        int rem = n%10;
        return rem*(int)(Math.pow(10,digits-1))+helper(n/10,digits-1);
    }

    public static void main(String[] args) {
        int n = 1234;
        //1st method
//        System.out.println(ReverseNum(n));

        //2nd method -
//        ReverseNumRec(n);
//        System.out.println(sum);

        //3rd Mehtod -
        System.out.println(ReverseNumRec2(n));;
    }

}
