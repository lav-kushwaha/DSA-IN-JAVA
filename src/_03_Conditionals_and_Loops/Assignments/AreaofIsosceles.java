package _03_Conditionals_and_Loops.Assignments;
import java.util.Scanner;
public class AreaofIsosceles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a base: ");
        double base = sc.nextDouble();
        System.out.println("Enter a height: ");
        double height = sc.nextDouble();
        double result = Isosceles(base,height);
        System.out.println(result);
    }
    public static double Isosceles(double base, double height ){
            double areaofisosceles = (base*height)/2;
            return areaofisosceles;
    }
}
