package _14_Recursion_Questions;

public class Q8_CountZeros {
    //Method-1 Counting Zeros.
    static int CountZeroDigits(int n){
        int count = 0;
        while(n!=0){
            int digits = n%10;

            //condtion to count zeros.
            if(digits == 0){
                count++;
            }
            n/=10;
        }
        return count;
    }

    //Method-2 Counting Zeros Using Recursion.
    static int countZeros(int number){
        // Base case
        if (number == 0) {
            return 1; // if the number itself is 0, return 1
        }
        if (number < 10) {
            return 0; // if the number is single digit and not 0, return 0
        }

        // Recursive case
        int lastDigit = number % 10;
        if (lastDigit == 0) {
            // If last digit is 0, increment the count
            return 1 + countZeros(number / 10);
        } else {
            // If last digit is not 0, continue with the rest of the number
            return countZeros(number / 10);
        }
    }

    //Method -3 Count Number using recursion by kk.
    static int count(int n){
        return helper(n,0);
    }

    static int helper(int n, int c){
        if(n==0){
            return c;
        }
        int rem = n%10;
        if(rem == 0){
            return helper(n/10,c+1);
        }
        else {
            return helper(n/10,c);
        }
    }


    public static void main(String[] args) {
        int n = 302040;

        //Method -1
        //Counting Zeros.
//        int ans = CountZeroDigits(n);
//        System.out.println(ans);

        //Method - 2
        //Couting Zeros using recursion.
//        System.out.println(countZeros(n));

        //Method -3
        System.out.println(count(n));
    }
}
