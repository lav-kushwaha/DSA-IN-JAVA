package _02_First_Java_Program.Questions;

public class PrintingNumber1To10 {
    public static void printNos(int N){
        if(N>0){
            printNos(N-1);//recursive call
            System.out.print(N+" ");
        }
    }
    public static void main(String[] args) {
        int num = 10;
        printNos(num);
    }
}
