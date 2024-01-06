package _02_First_Java_Program.Assignments;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num1 :");
        int num1 = sc.nextInt();
        System.out.println("Enter num2 :");
        int num2 = sc.nextInt();
        System.out.println("Enter What you have to perform, Add,Sub,Multiply,Division :");
        String str = sc.next();
        if (str.equals("Add")) {
            int add = num1 + num2;
            System.out.println("Result: " + add);
        } else if (str.equals("Sub")) {
            int sub = num1 - num2;
            System.out.println("Result: " + sub);
        } else if (str.equals("Multiply")) {
            int multiply = num1 * num2;
            System.out.println("Result: " + multiply);
        } else if (str.equals("Division")) {
            // Check for division by zero
            if (num2 != 0) {
                int div = num1 / num2;
                System.out.println("Result: " + div);
            } else {
                System.out.println("Error: Division by zero is not allowed.");
            }
        } else {
            System.out.println("Please enter a valid input");
        }
    }
}
