package _14_Recursion_Questions.Recursion_Pattern_Questions;
/*
//Q.1 Print triangle using recursion.

 ****
 ***
 **
 *

 */

public class Q1_PrintTriangleUsingRecursion {
    public static void main(String[] args) {
        triangle(4,0);
    }
    static void triangle(int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
            System.out.print("*");
            triangle(r,c+1);
        }else{
            System.out.println(" ");
            triangle(r-1,0);
        }
    }
}
