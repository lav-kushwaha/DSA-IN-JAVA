package _20_StringBuffer;

public class StringBufferExample {
    public static void main(String[] args) {

        //constructor 1
        StringBuffer sb = new StringBuffer();

        //constructor 2
        StringBuffer sb2 = new StringBuffer("Lav Kushwaha");

        //constructor 3
        StringBuffer sb3 = new StringBuffer(30);

        //Different methods :
        sb.append("Hello world");

        //its appended and it's not created new object.
//        sb.append("String buffer");

//        sb.insert(11, " Lav ");

//        sb.reverse();

        sb.replace(0,5,"lav");

        String str = sb.toString();
        System.out.println(str);

    }
}
