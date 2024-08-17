package _06_Intro_To_Arrays_And_ArrayList;

public class MutableArrays {
    //In Java, arrays are indeed mutable.
    // This means that you can modify the elements of an array after it has been created.
    // Here's an example to illustrate this:
    public static void main(String[] args) {
        // Creating an array
        int[] numbers = {1, 2, 3, 4, 5};

        // Modifying an element in the array
        numbers[2] = 10;

        // Printing the modified array
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
