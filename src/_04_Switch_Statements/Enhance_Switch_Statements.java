package _04_Switch_Statements;

import java.util.Scanner;

public class Enhance_Switch_Statements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();

        switch(day){
            case 1,2,3,4,5 -> System.out.println("Weekdays");
            case 6,7 -> System.out.println("Weekend");
        }


    }
}
