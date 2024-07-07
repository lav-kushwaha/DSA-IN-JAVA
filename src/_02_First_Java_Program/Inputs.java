package _02_First_Java_Program;

import java.util.Scanner;

public class Inputs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Taking input from the user.
        int rollno = sc.nextInt();
        System.out.println("Your roll no is "+ rollno);
    }
}
