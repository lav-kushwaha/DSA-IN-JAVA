package _05_Functions_In_Java;

public class Shadowing {
    static int x = 90; //this will be shadowed at line 8.
    public static void main(String[] args) {
        System.out.println(x);//90
        int x = 40;//the class variable at line 4 is shadowed by this
        System.out.println(x);//40
        fun();

        /*
       int x;//declaration
       System.out.println(x);//scope will begin when value is initialised.
       x = 20;
        */
    }
    static void fun(){
        System.out.println(x);//90
    }

}
