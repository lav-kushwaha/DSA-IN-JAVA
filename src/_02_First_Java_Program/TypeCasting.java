package _02_First_Java_Program;
import java.util.Scanner;
public class TypeCasting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        float num = sc.nextFloat();//2.2
        //This is a type casting converting float data-types to int data-types.
//        int ans = (int) (num);//2 here float is converted into int data types.
//        System.out.println(ans);//2


        //Explicit Typecasting.(Narrowing)
//        float num = 10.5f;
//        int convertingnumtofloat = (int)(num);
//        System.out.println(convertingnumtofloat);

        byte a = 10;
        //here this expression will not multiply bcz its ans expression or whenever we do expression then it will converted to int.
//        byte ans = a*2;
//         int ans = a*2;

        byte b = 42;
        char c = 'a';
        short s = 1024;
        int i = 50000;
        float f = 5.67f;
        double d = 0.1234;
        double result = (f*b)+(i/c)-(d*s);//always smaller primitive data types converted to bigger.
        // float + int - double = double.
        System.out.println((f*b)+ " " +(i/c)+ " " +(d*s));//238.14 515 126.3616
        System.out.println(result);//626.7784146484375


    }
}
