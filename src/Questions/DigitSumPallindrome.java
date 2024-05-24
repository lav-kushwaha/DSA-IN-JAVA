package Questions;

class DigitSumPallindrome {
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
        if(sum==reverse){
            return 1;
        }
        else{
           return 0;
        }
    }

    public static void main(String[] args) {
        int ans = isDigitSumPalindrome(56);
        System.out.println(ans);
    }
}