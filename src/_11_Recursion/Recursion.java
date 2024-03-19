package Recursion;

public class Recursion {
    public static void main(String[] args) {
//        int ans =sum(10);
//        System.out.println(ans);

        print(1);
        name(1);
        FibonacciSeries(10);
    }
//    static int sum(int k){
//        //if n is 5 then stop it.
//        if (k > 0) {
//            return k + sum(k - 1);
//        } else {
//            return 0;
//        }
//    }
    static void print(int n){
        if(n==5){
            System.out.println(n);
            return;
        }
        System.out.println(n);

        //recursive call.
        //if you are calling a function again and again, you can treat it as a separate call in the stack.
        //this is called tail recursion.
        //this is a last function caled.
        print(n+1);
    }
    static void name(int n){
        if(n==3){
            return;
        }
        System.out.println("I love myself");
        name(n+1);
    }

    //fibonacci series.
    static void FibonacciSeries(int n){
      int a=0;
      int b=1;
      int c;
      for(int i=0;i<n;i++){
          System.out.print(a+" ");
          c = a+b;
          a=b;
          b=c;
      }
    }



}
