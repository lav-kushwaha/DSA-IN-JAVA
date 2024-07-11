package _09_StringsAndStringBuilder.StringBuilder;

public class StringBuilderExample {
    public static void main(String[] args) {
        // Creating a StringBuilder object
        StringBuilder sb = new StringBuilder("Hello");
        
        // Appending strings
        sb.append(" World");
        System.out.println(sb.toString());  // Output: Hello World

        // Inserting strings
        sb.insert(6, "Java ");
        System.out.println(sb.toString());  // Output: Hello Java World

        // Replacing part of the string
        sb.replace(6, 10, "Beautiful");
        System.out.println(sb.toString());  // Output: Hello Beautiful World

        // Deleting part of the string
        sb.delete(6, 16);
        System.out.println(sb.toString());  // Output: Hello World

        // Reversing the string
        sb.reverse();
        System.out.println(sb.toString());  // Output: dlroW olleH

        // Converting back to a regular string
        String result = sb.toString();
        System.out.println(result);  // Output: dlroW olleH
    }
}
