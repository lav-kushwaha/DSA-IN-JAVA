package _14_Recursion_Questions.Recursion_Pattern_Questions;

public class Q2_PrintTriangle {
    public static void main(String[] args) {
        triangle(5,0);
    }
    static void triangle(int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
            triangle(r,c+1);
            System.out.print("*");
        }else{
            triangle(r-1,0);
            System.out.println(" ");
        }
    }
}
