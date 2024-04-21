package _13_MathsForDSA.BitwiseAndNumberSystem.Questions;
import java.util.Scanner;
public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to check no. is even or odd: ");
        int num = sc.nextInt();
        if((num & 1) == 1){
            System.out.println("Number is odd ");
        }else{
            System.out.println("Number is even");
        }
    }
}
