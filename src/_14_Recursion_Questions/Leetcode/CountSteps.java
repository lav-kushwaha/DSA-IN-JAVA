package _14_Recursion_Questions.Leetcode;

//1342. Number of Steps to Reduce a Number to Zero.
//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/

public class CountSteps {
    public static void main(String[] args) {
        int n = 123;
        //Method-1 using recursion ans.
        System.out.println(Count(n));

        //Method-2- Without recursion Answer.
//        System.out.println(numberOfSteps(n));
    }

    static int Count(int n){
        return helper(n,0);
    }

    //This helper function will give me a count.
    static int helper(int num, int count){
        //if number is single digit then return count itself.
        // this is base case.
        if(num%10==0){
            return count;
        }
        //this if condition will check num is even or odd.
        // if num is even then
        if(num%2==0){
            return helper(num/2,count+1);//recursive call
        }else{
            return helper(num-1,count+1);
        }
    }

    //2nd method without using recursion.
//    static int numberOfSteps(int num) {
//        int countStep = 0;
//        while(num!=0){
//            //if num is even. then divide by 2 and count the step.
//            if(num%2==0){
//                countStep++;
//                num = num/2;
//            }
//            // if num is odd then subtract num-1 and count the step.
//            else{
//                num = num-1;
//                countStep++;
//            }
//        }
//        return countStep;
//    }
}
