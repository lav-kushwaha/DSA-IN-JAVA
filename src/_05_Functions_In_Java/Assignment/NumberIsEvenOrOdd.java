package _05_Functions_In_Java.Assignment;

import java.util.Scanner;

//Define a program to find out whether a given number is even or odd.
public class NumberIsEvenOrOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check number is even or odd: ");
        int num = sc.nextInt();
        boolean ans = EvenOROdd(num);
        if(ans){
            System.out.println("Number is even number");
        }
        else {
            System.out.println("Number is odd number");
        }
        sc.close();
    }
    static boolean EvenOROdd(int num){
        return num%2==0;
    }

}
