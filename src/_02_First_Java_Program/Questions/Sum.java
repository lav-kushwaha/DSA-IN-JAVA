package _02_First_Java_Program.Questions;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //taking input
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        //sum of two numbers
        int sum = num1+ num2;

        System.out.println("Sum = "+ sum);
    }
}
