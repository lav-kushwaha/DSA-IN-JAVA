package _02_First_Java_Program.Assignments;
import java.util.Scanner;
public class CheckNumIsEvenOrOdd {
    public static void main(String[] args) {
        System.out.println("Enter Number to Check Even Or Odd: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if(input%2==0){
            System.out.println("Number is Even");
        }
        else {
            System.out.println("Number is odd");
        }
    }
}
