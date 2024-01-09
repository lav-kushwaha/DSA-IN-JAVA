package _03_Conditionals_and_Loops.Assignments;
import java.util.Scanner;
public class AreaOfRectangle {
    //AreaOfRectangle = l*w;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a length: ");
        double length = sc.nextDouble();
        System.out.println("Enter a width: ");
        double width = sc.nextDouble();
        double result = Rectangle(length,width);
        System.out.println(result);
    }
    public static double Rectangle(double length,double width){
         double rectangle = length * width;
         return rectangle;
    }
}
