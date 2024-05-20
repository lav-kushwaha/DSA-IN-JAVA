package Questions.Concepts;

public class swapped {
    public static void main(String[] args) {
        int[] arr = {10, 20};
        swap(arr, 0, 1);
        System.out.print(arr[0] + " " + arr[1]); // Output: 20 10
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

//Note:
//class Swapped {
//
//    public static void main(String[] args) {
//        int a = 10;
//        int b = 20;
//        swap(a, b);
//        System.out.print(a + " " + b);
//    }
//
//    public static void swap(int a, int b) {
//        int temp = a;
//        a = b;
//        b = temp;
//    }
//}

//Note : please note that this implementation will not actually swap the values of a and b in the main method because
// Java passes arguments by value, not by reference.
// Therefore, any changes made to a and b inside the swap method will not affect the original variables.
