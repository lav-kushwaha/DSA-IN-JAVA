package _02_First_Java_Program;

import java.util.Scanner;

public class TypeCasting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float num = sc.nextFloat();//2.2
        //This is a type casting converting float data-types to int data-types.
        int ans = (int) (num);//2 here float is converted into int data types.
        System.out.println(ans);//2
    }
}
