package _05_Functions_In_Java.Assignment;

import java.util.Scanner;

public class MaximumAndMinimumAmongThreeeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter a number2: ");
        int num2 = sc.nextInt();
        System.out.println("Enter a number3: ");
        int num3 = sc.nextInt();
        System.out.println("Maximum Number Among Three Num is :" + MaximumNumber(num1, num2, num3));
        System.out.println("Minimum Number Among Three Num is :" + MinimumNumber(num1, num2, num3));
    }

    static int MaximumNumber(int num1, int num2, int num3) {
        int max = num1;
        if (num2 > max) {
            max = num2;
        }
        if (num3 > max) {
            max = num3;
        }
        return max;
    }

    static int MinimumNumber(int num1, int num2, int num3) {
        int min = num1;
        if (num2 < min) {
            min = num2;
        }
        if (num3 < min) {
            min = num3;
        }
        return min;
    }
}
