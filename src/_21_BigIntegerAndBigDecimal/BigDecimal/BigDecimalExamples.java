package _21_BigIntegerAndBigDecimal.BigDecimal;
import java.math.BigDecimal;

//Learn About BigDecimal More From Docs.
//Official Docs : https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html

public class BigDecimalExamples {

    //Example 01 :The minor error in the output arises because floating-point numbers cannot represent all decimal fractions exactly.
     static void BD(){
        double a = 0.03;
        double b = 0.04;
        double ans = b-a;
        System.out.println(ans);//0.010000000000000002 (minor error in the ans bcs float and double are floating-point)
     }

     //Example 02 : Creating BigDecimal Objects: Instead of using double, create BigDecimal objects using string representation to avoid precision errors.
    static void BD1(){
        BigDecimal a = new BigDecimal("0.03");
        BigDecimal b = new BigDecimal("0.04");
        BigDecimal ans = b.subtract(a);
        //System.out.println(ans); // Should correctly print 0.01

        //OPERATIONS :

        //Addition
        System.out.println(b.add(a));//0.07

        //Subtraction
        System.out.println(b.subtract(a));//0.01

        //Multiply
        System.out.println(b.multiply(a));//0.0012

        //Remainder
        System.out.println(b.remainder(a));//0.01

        //pow or square
        System.out.println(a.pow(2));//0.0009

        //negate - it will gives negative values.
        System.out.println(a.negate());//-0.03


        //CONSTANTS
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal one = BigDecimal.ONE;
        BigDecimal ten = BigDecimal.TEN;
        System.out.println(zero+" "+one+" "+ten);//0 1 10
    }

    public static void main(String[] args) {
        //BD();
        BD1();
    }
}
