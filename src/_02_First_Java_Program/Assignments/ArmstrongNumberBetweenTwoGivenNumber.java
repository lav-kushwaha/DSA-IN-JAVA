package _02_First_Java_Program.Assignments;
import java.util.Scanner;
public class ArmstrongNumberBetweenTwoGivenNumber {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the lower limit: ");
            int lowerLimit = scanner.nextInt();

            System.out.print("Enter the upper limit: ");
            int upperLimit = scanner.nextInt();

            System.out.println("Armstrong numbers between " + lowerLimit + " and " + upperLimit + ":");
            findArmstrongNumbers(lowerLimit, upperLimit);

        }

        static void findArmstrongNumbers(int lowerLimit, int upperLimit) {
            for (int number = lowerLimit; number <= upperLimit; number++) {
                if (isArmstrongNumber(number)) {
                    System.out.println(number);
                }
            }
        }

        static boolean isArmstrongNumber(int num) {
            int originalNum = num;
            int numberOfDigits = String.valueOf(num).length();
            int sum = 0;

            while (num > 0) {
                int digit = num % 10;
                sum += Math.pow(digit, numberOfDigits);
                num /= 10;
            }

            return sum == originalNum;
        }
    }
