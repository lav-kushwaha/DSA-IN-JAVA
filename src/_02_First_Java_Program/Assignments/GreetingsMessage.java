package _02_First_Java_Program.Assignments;

import java.util.Scanner;

public class GreetingsMessage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello "+ name);

    }
}
