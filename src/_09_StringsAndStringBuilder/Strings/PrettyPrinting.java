package _09_StringsAndStringBuilder.Strings;

public class PrettyPrinting {
    public static void main(String[] args) {
        float a = 452.345f;
        //% is placeholder and till 2 decimal value i wanted to be print
        System.out.printf("Formatted string %.2f \n",a);

        //System.out.printf("The pi value is %.2f",Math.PI);//The pi value is 3.14

        //for string
        System.out.printf("Hello my name is %s and i am %s","Lav","Kushwaha");//Hello my name is Lav and i am Kushwaha.
    }
}
