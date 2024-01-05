package _02_First_Java_Program.Questions;

import java.util.Scanner;

public class CelsiusTofahrenheit {
    public static void main(String[] args) {
        System.out.println("Enter a temperature in celsius: ");
        Scanner sc = new Scanner(System.in);
        float celsius = sc.nextFloat();
        float fahrenheit = (celsius * 9/5)+ 32;
        System.out.println(fahrenheit);
    }
}
