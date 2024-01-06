package _02_First_Java_Program.Assignments;
import java.util.Scanner;
public class CheckStringPallindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a string to check string is pallindrome or not: ");
        String str = sc.next();
        String input =  str.toLowerCase();
        String reverse = "";
        for(int i=str.length()-1;i>=0;i--){
            reverse = reverse + str.charAt(i);
        }
        if(str.equals(reverse)){
            System.out.println("Input String is a pallindrome");
        }else {
            System.out.println("Input String is not a pallindrome");
        }
    }
}
