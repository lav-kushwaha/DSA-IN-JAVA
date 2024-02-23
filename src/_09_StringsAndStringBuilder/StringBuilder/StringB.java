package _09_StringsAndStringBuilder.StringBuilder;

//Q. What is stringbuilder?
//StringBuffer objects are mutable, meaning that you can change the contents of the buffer without creating a new object.
//StringBuffer is a class in Java that represents a mutable sequence of characters. It provides an alternative to the immutable String class, allowing you to modify the contents of a string without creating a new object every time.
public class StringB {
    public static void main(String[] args) {
        //This is mutable.
        //It is not creating new object everytime.
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            char ch =(char)('a'+i);
            sb.append(ch);
        }
        System.out.println(sb);//abcdefghijklmnopqrstuvwxyz
        System.out.println(sb.reverse());//zyxwvutsrqponmlkjihgfedcba
        System.out.println(sb.deleteCharAt(0));//bcdefghijklmnopqrstuvwxyz
        System.out.println(sb.delete(0,12));//mnopqrstuvwxyz

        //Example-2.
        //Here you can se string is mutable thats means it is not creating new object everytime. it is modifying current object.
        StringBuffer sb1 = new StringBuffer();
        sb1.append("Hello");
        sb1.append(" ");
        sb1.append("world");
        String message = sb1.toString();
        System.out.println(message);

        //Example-3 (append) method.
        //append() method
        //The append() method concatenates the given argument with this string.
        StringBuffer sb2 = new StringBuffer("Hello ");
        sb2.append("Java"); // now original string is changed
        System.out.println(sb2);

        //Example-04.
        //insert() method.
        //The insert() method inserts the given string with this string at the given position.
        StringBuffer sb3 = new StringBuffer("Hello ");
        sb3.insert(1, "Java");
        // Now original string is changed
        System.out.println(sb3);//HJavaello.



    }
}
