package _09_StringsAndStringBuilder.Strings;

import java.util.Arrays;

public class Methods {
    public static void main(String[] args) {
        String a = "LavKushwaha hello java";
        //toUpperCase().
        String b = a.toUpperCase();
        System.out.println(b);//LAVKUSHWAHA.

        //toLowerCase().
        String c = a.toLowerCase();
        System.out.println(c);//lavkushwaha

        System.out.println(Arrays.toString(a.toCharArray()));//[L, a, v, K, u, s, h, w, a, h, a]

        //strip are used to remove space.
        System.out.println("    lavkushwaha   ".strip());

        //split
        System.out.println(Arrays.toString(a.split(" ")));//[LavKushwaha, hello, java]
    }
}
