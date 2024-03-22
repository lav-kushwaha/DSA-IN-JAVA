package _14_Recursion_Questions.Recursion_Level_01_Questions;

public class Concepts {
    public static void main(String[] args) {
        fun(5);
    }
    static void fun(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
//        fun(--n);//stack overflow
        fun(--n);
    }
}

//#Difference between n-- vs --n
/*
n = n-1
#post-decrement operator
=> n-- first returns the current value of n and then decrements it.
i.e,
int n = 5;
int result = n--; // result is 5, n is now 4

#pre-decrement operator
=> --n decrements first and then returns the updated value.
i.e,
int n = 5;
int result = --n; // result is 4, n is now 4
 */