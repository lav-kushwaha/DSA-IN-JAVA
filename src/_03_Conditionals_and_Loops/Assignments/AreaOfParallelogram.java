package _03_Conditionals_and_Loops.Assignments;
import java.util.Scanner;
public class AreaOfParallelogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a base: ");
        double base = sc.nextDouble();
        System.out.println("Enter a height: ");
        double height = sc.nextDouble();
        double result = parallelogram(base,height);
        System.out.println(result);
    }
    public static double parallelogram(double base, double height ){
        double areaofparallelogram = base*height;
        return areaofparallelogram;
    }
}
