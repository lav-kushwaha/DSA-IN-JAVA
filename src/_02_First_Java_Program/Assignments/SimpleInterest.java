package _02_First_Java_Program.Assignments;

import java.util.Scanner;
public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a principal :");
        int principal = sc.nextInt();
        System.out.println("Enter a time period:");
        int time = sc.nextInt();
        System.out.println("Enter a rate: ");
        int rate = sc.nextInt();
        double SimpleInterest = (principal * time * rate) / 100.0;
        System.out.println("Simple Interest is "+ SimpleInterest);
    }
}
