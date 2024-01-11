package _05_Functions_In_Java.Assignment;

import java.util.Scanner;

//Q.Write a program to print the sum of two numbers entered by user by defining your own method.
public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter a number2: ");
        int num2 = sc.nextInt();
        int result = SumOfTwoNumbers(num1,num2);
        System.out.println(result);
    }
    static int SumOfTwoNumbers(int num1,int num2){
        int sum = num1+num2;
        return sum;
    }
}
