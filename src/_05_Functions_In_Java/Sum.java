package _05_Functions_In_Java;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        /*Q.1 Take a inputs num1 and num2*/

        /*Q.What if a person say do this code 1000 times so its kind of not possible so instead of writing code again and again we can create a function*/
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a num1: ");
//        int num1 = sc.nextInt();
//        System.out.println("Enter a num2: ");
//        int num2 = sc.nextInt();
//        int sum = num1+num2;
//        System.out.println(sum);

        //Creating a functions.(By creating a functions we can re-use our code again and again;
//        sum();

        //creating a return-type function which will return some value.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a num1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter a num2: ");
        int  num2 = sc.nextInt();

        //function called here.
        int ans = Sum2(num1,num2);
        System.out.println(ans);
    }
    //return value from methods.
    static int Sum2 (int num1 ,int num2){
        int sum = num1+num2;
        return sum;
    }

    //this function will not return anything bcz its return-type is void.
//    static void sum(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a num1: ");
//        int num1 = sc.nextInt();
//        System.out.println("Enter a num2: ");
//        int num2 = sc.nextInt();
//        int sum = num1+num2;
//        System.out.println(sum);
//    }

}
