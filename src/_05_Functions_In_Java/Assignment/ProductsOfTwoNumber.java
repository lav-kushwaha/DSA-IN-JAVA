package _05_Functions_In_Java.Assignment;

import java.util.Scanner;

public class ProductsOfTwoNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a num1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter a num2: ");
        int num2 = sc.nextInt();
        int ans = ProductsOfTwoNumber(num1,num2);
        System.out.println(ans);

    }
    static int ProductsOfTwoNumber(int num1,int num2){
          int products = num1 * num2;
          return products;
    }

}
