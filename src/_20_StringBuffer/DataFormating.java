package _20_StringBuffer;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class DataFormating {
    public static void main(String[] args) {
        //Generating random float
        Random random = new Random();
        System.out.println(random.nextFloat());//it will give random integer from 0 to 1

        //remove whitespaces
        String sentences = "Hi hel" +
                "lo lav kushwhaha";
        System.out.println(sentences);
        System.out.println(sentences.replaceAll("\s",""));//removing whitespaces

        //split
        String arr = "Apple,Ball,Cat,Dog";
        String [] names = arr.split(",");//from "," I want to do split.
        System.out.println(Arrays.toString(names));//[Apple, Ball, Cat, Dog]

        //rounding off
        DecimalFormat df = new DecimalFormat("00.0000");
        System.out.println(df.format(7.34));//07.3400
    }
}
