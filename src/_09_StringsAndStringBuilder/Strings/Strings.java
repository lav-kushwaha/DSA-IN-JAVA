package _09_StringsAndStringBuilder.Strings;

public class Strings {
    public static void main(String[] args) {
        //There are two way to creating an objects.
        //1.way
        String str = "LavKushwaha";

        //2.way
        String str1 = new String("lavkushwaha");

        //String is immutable we can't change.
        String name = "Lav";
        System.out.println(name);
        //Here i have created another object "Ram" the original one is not change.
        name = "Ram";
        System.out.println(name);//Ram
    }
}
