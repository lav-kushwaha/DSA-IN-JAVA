package _20_StringBuffer;
import java.util.Random;

public class RandomString {
    static String generate(int size){
        StringBuffer sb = new StringBuffer(size); //it will not create new object individually everytime it will make change that only.
        Random random = new Random();

        for (int i = 0; i < size; i++) {
           int randomChar = 97+(int)(random.nextFloat()*26);
           sb.append((char)randomChar+" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generate(26));
    }
}
