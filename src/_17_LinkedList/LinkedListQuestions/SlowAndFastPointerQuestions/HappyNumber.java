package _17_LinkedList.LinkedListQuestions.SlowAndFastPointerQuestions;

//https://leetcode.com/problems/happy-number/
//202. Happy Number

class HappyNumber {

   public static int digitSquareSum(int num) {
        int sum = 0;
        while (num != 0) {
           int rem = num % 10;
            sum += rem * rem;
            num /= 10;
        }
        return sum;
    }
    
    public static boolean isHappy(int num) {
        int slow = num;
        int fast = num;

        do {
            slow = digitSquareSum(slow); //move one step.
            fast = digitSquareSum(digitSquareSum(fast)); //move two step.
        } while (slow != fast);
        return slow == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
