package _05_Functions_In_Java;

public class Greetings {
    public static void main(String[] args) {
        String name = Greet("Lav Kushwaha");
        System.out.println(name);
        Greet();
    }
    //String return-type method.
    static String Greet(String name){
        String msg = "Hello "+ name;
        return msg;
    }

    //this function Greet will not return anything because its return type is void.
    static void Greet(){
        System.out.println("Hello world");
    }


}
