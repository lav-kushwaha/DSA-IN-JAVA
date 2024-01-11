package _05_Functions_In_Java.Assignment;
import java.util.Scanner;
//Q.A person is eligible to vote if his/her age is greater than or equal to 18. Define a method to find out if he/she is eligible to vote.
public class Vote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        boolean result = EligibleForVoteOrNot(age);
        if(result){
            System.out.println("You are eligible for vote");
        }
        else{
            System.out.println("You are not eligible for vote");
        }
    }
    static boolean EligibleForVoteOrNot(int age){
        if(age>=18){
            return true;
        }
        return false;
    }

}

