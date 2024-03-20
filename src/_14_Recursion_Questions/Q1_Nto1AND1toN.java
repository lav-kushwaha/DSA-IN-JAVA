package _14_Recursion_Questions;

public class Q1_Nto1AND1toN {
    public static void main(String[] args) {
        fun(5);
        funRev(5);

    }

    //N to 1
    static void fun(int n){
        //base condition
        if(n==0){
            return;
        }
        //Nto1
       System.out.println(n);
        fun(n-1);
    }

    //1 to N
    static void funRev(int n){
        //base condition
        if(n==0){
            return;
        }
        funRev(n-1);//once this function is finished called then it will go to the line no. 29. i.e - sout(n)
        //1toN =>why this is bcz of remember the concept of callstack
        System.out.println(n);
    }
}
