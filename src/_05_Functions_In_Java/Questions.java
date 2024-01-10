package _05_Functions_In_Java;

import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
       boolean result = IsPrime(num);
        System.out.println(result);

        for (int i = 100; i < 1000; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }

    }

    // print all the 3 digits armstrong numbers
    static boolean isArmstrong(int n) {
        int original = n;
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            sum = sum + rem*rem*rem;
        }
        return sum == original;
    }


    //Write a program to check number is prime or not.
    static boolean IsPrime(int num){
        int originalNum = num;
        int start = 2;
        boolean isPrime = true;
        while(originalNum>start){
            if(originalNum%start==0){
                isPrime = false;
                break;//Add this break statement
            }
            start++;
        }
        if(isPrime){
            return true;
        }
        return false;
    }
}
