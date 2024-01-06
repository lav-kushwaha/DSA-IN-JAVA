package _02_First_Java_Program.Assignments;
import java.util.Scanner;

public class ConvertingRupeesToUSD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the amount in Indian Rupees
        System.out.print("Enter the amount in Indian Rupees (INR): ");
        double inrAmount = scanner.nextDouble();

        // Input the exchange rate from INR to USD
        System.out.print("Enter the exchange rate from INR to USD: ");
        double exchangeRate = scanner.nextDouble();

        // Calculate the equivalent amount in USD
        double usdAmount = inrAmount / exchangeRate;

        // Display the result
        System.out.println("Equivalent amount in USD: " + usdAmount);

        scanner.close();
    }
}
