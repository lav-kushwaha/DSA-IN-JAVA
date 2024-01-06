package _02_First_Java_Program.Assignments;
import java.util.Scanner;
public class LargestNumBetween2Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number1");
        int num1 = sc.nextInt();
        System.out.println("Enter number2");
        int num2 = sc.nextInt();
        if(num1>num2){
            System.out.println("Number 1 is greater than number 2: ");
        }
        else{
            System.out.println("Number 2 is greater than number 1: ");
        }
    }
}
