package _09_StringsAndStringBuilder.StringBuilder;

public class StringB {
    public static void main(String[] args) {
        // Example-1: Demonstrating StringBuilder mutability
        //This is mutable.
        //It is not creating new object everytime.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            sb.append(ch);
        }
        System.out.println(sb); // Output: abcdefghijklmnopqrstuvwxyz
        System.out.println(sb.reverse()); // Output: zyxwvutsrqponmlkjihgfedcba
        System.out.println(sb.deleteCharAt(0)); // Output: yxwvutsrqponmlkjihgfedcba
        System.out.println(sb.delete(0, 12)); // Output: mnopqrstuvwxyz

        // Example-2: Using StringBuilder for concatenation
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Hello");
        sb1.append(" ");
        sb1.append("world");
        String message = sb1.toString();
        System.out.println(message); // Output: Hello world

        // Example-3: append() method with StringBuilder
        StringBuilder sb2 = new StringBuilder("Hello ");
        sb2.append("Java"); // Now original string is changed
        System.out.println(sb2); // Output: Hello Java

        // Example-4: insert() method with StringBuilder
        StringBuilder sb3 = new StringBuilder("Hello ");
        sb3.insert(1, "Java");
        // Now original string is changed
        System.out.println(sb3); // Output: HJavaello
    }
}
