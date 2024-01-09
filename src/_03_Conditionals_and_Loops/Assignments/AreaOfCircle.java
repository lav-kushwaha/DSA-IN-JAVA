package _03_Conditionals_and_Loops.Assignments;

import java.util.Scanner;
public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a radius: ");
        double radius = sc.nextDouble();
        double pi = 3.14;
        double ans = AreaofCircle(radius, pi);
        System.out.println("Area of circle is : "+ ans);
    }
    public static double AreaofCircle(double radius, double pi) {
        double areaOfCircle = pi * radius * radius;
        return areaOfCircle;
    }
}
