package _02_First_Java_Program.Assignments;
public class FibonacciSeries_Upto_N_Numbers {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int c = 0;
        int num =10;
        for(int i=0; i<=num;i++){
             System.out.print(c+ " ");
             c = a+b;
             a = b;
             b = c;
         }
        System.out.println(c);
    }

    //We can do this by using forloop as well.
//    int a = 0;
//    int b = 1;
//    int c = 0;
//    int num = 10;
//    int start = 0;
//      while(start<=num){
//        System.out.print(c+ " ");
//        c = a+b;
//        a = b;
//        b = c;
//        start++;
//    }
}
