package _04_Switch_Statements;

import java.util.Scanner;

public class Calculator_Using_Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter operator: +, -, *, /");
        String operator = sc.next();

        System.out.println("Enter num1: ");
        int num1 = sc.nextInt();

        System.out.println("Enter num2: ");
        int num2 = sc.nextInt();

        int result = 0; // Declare a variable to store the result

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Cannot divide by zero");
                    return; // Exit the program if division by zero is attempted
                }
                break;
            default:
                System.out.println("Please enter a valid operator");
                return; // Exit the program if an invalid operator is entered
        }

        System.out.println("Result: " + result);
    }
}
