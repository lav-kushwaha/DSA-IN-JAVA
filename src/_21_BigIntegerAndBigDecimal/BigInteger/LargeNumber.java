package _21_BigIntegerAndBigDecimal;
import java.math.BigInteger;

//Learn About BigInteger More From Docs.
//Official Docs : https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/math/BigInteger.html

public class LargeNumber {
    public static void main(String[] args) {
        //Normal primitive datatype int
        int a = 10;
        int b = 20;

        //The BigInteger.valueOf method only accepts long values, not strings.
//        BigInteger A = BigInteger.valueOf(20);
//        BigInteger B = BigInteger.valueOf(30);

        //To create a BigInteger from a string, you should use the BigInteger constructor that accepts a string as an argument.
        BigInteger C = new BigInteger("2222");

        //constants
        BigInteger D = BigInteger.ZERO;
        BigInteger E = BigInteger.ONE;
        BigInteger F = BigInteger.TEN;

//        System.out.println(D+" "+E+" "+F);//0 1 10

        //addition(A+B = s)
        BigInteger a1 = BigInteger.valueOf(20);
        BigInteger a2 = BigInteger.valueOf(30);
        BigInteger add = a1.add(a2);
//        System.out.println(add);//50

        //addition of two num in string.
        BigInteger G = new BigInteger("2384438758475557785214635219013381984498784757");
        BigInteger H = new BigInteger("55664648751212151454484021354687898878905664434");
        BigInteger Add = G.add(H);
//        System.out.println(Add);//58049087509687709239698656573701280863404449191

        //Multiply
        BigInteger m = BigInteger.valueOf(20);
        BigInteger m1 = BigInteger.valueOf(30);
        BigInteger multiply = m.multiply(m1);
        System.out.println(multiply);//600

        //Divide
        BigInteger d1 = BigInteger.valueOf(20);
        BigInteger d2 = BigInteger.valueOf(5);
        BigInteger divide = d1.divide(d2);
        System.out.println(divide);//4

        //remainder
        BigInteger r1 = BigInteger.valueOf(36);
        BigInteger r2 = BigInteger.valueOf(5);
        BigInteger remainder = r1.remainder(r2);
        System.out.println(remainder);//1

        //compareTo
        if(r2.compareTo(r1)<0){ //r2<r1 which is true.
            System.out.println("yes");
        }

    }
}
