package Questions.RecursionPractice;

public class FirstProgram {
    public static void main(String[] args) {
//        print(1);
        System.out.println(fib(4));
    }

    static void print(int n){
        if(n==5){
            System.out.println(n);
            return;
        }

        print(n+1);//recursive call
        System.out.println(n); //print the no
    }

    //fibonacci series using recursion.
    static int fib(int n){
        if(n<2){ //base conditon.
            return n;
        }
        return fib(n-1)+fib(n-2);//recursive call
    }
}
