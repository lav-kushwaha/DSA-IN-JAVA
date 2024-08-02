package Questions;

//https://www.geeksforgeeks.org/problems/sum-of-digit-is-pallindrome-or-not2751/0
//Sum of Digit is Pallindrome or not

class DigitSumPallindrome {

    //Check is digittal sum palindrome or not
   static int isDigitSumPalindrome(int N) {
        // code here
         int sum = 0;
        while(N!=0){
            int digit = N%10;
            sum = sum+digit;
            N = N/10;
        }
        
        int num=sum;
        int reverse = 0;
        while(num!=0){
            int digits = num % 10;
            reverse = reverse * 10 + digits;
            num = num/10;
        }

        //check sum is equal to reverse no. or not.
        if(sum==reverse){
            return 1;
        }
        else{
           return 0;
        }
    }

    public static void main(String[] args) {
        int ans = isDigitSumPalindrome(56); //sum : 5+6 = 11
        System.out.println(ans);
    }
}