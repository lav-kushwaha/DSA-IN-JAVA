package _06_Introduction_To_Arrays_And_ArrayList;
public class StringArrays {
    public static void main(String[] args) {
        // In Java, String objects are immutable. This means that once a String object is created, its content cannot be changed.
        // If you want to modify a String, a new String object is created with the desired modifications.

        String originalString = "Hello";

        // Concatenating a new string to the original one
        String modifiedString = originalString + " World";

        // The original string remains unchanged
        System.out.println("Original String: " + originalString);

        // The modified string contains the desired changes
        System.out.println("Modified String: " + modifiedString);
    }
}
