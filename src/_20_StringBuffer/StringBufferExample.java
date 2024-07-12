package _20_StringBuffer;

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("Hello world");

        System.out.println(sb);

        String str = sb.toString();
        System.out.println(str);

    }
}
