package _03_Conditionals_and_Loops.Assignments;

import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a base: ");
        double base = sc.nextDouble();
        System.out.println("Enter a height: ");
        double height = sc.nextDouble();
        double ans = AreaOfTriangle(base,height);
        System.out.println("Area of triangle is: "+ ans);
    }
    public static double AreaOfTriangle(double base,double height){
        double areaofatriangle =(1.0/2)*(base*height);
        return areaofatriangle;
    }

}
