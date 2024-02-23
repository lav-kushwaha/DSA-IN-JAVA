package _09_StringsAndStringBuilder.Strings;

import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        //it is a char adding ASCII values.
        System.out.println('a'+'b');//195
        System.out.println('a'-'b');//-1

        //Adding Ascii symbol.
        System.out.println('!'+'!');//66

        //adding strings.
        System.out.println("A"+"B");//concatinated AB.

//        System.out.println("A"-"B");//Compiler error. operator '-' cannot be applied in string.


        //adding ascii value with 3 integer.
        System.out.println('a'+3);// adding a+b+c+d which is 97+3=100

        //Ascii added with 3 integer. after adding it is given char of 100.
        System.out.println((char)('a'+3)); //ans is d bcz 100 is ASCII of d.

        //Adding string to integer--->Important.
        System.out.println("a"+10);//a10 when string is concatinated with integer then integer converted into toString().
        //this is same as after a few steps : "a"+"10"=a10 is ans.
        //integer will be converted to Integer that will call toString().

        //Adding strings with arraylist.
        System.out.println("Lav"+ new ArrayList<>());//Lav[].



    }
}
