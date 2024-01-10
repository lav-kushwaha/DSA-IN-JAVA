package _05_Functions_In_Java;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        //(...) varArgs are variable length arguments, it is a takes a number of arguments and return a array.
        fun(1,2,3,4,5);
    }
    static void fun(int ...v){
        System.out.println(Arrays.toString(v));//[1, 2, 3, 4, 5]
    }
}
