package _14_Recursion_Questions.Recursion_Array_Questions;

public class Q2_LinearSearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr ={};
        int target = 18;
        System.out.println("First Index: " + findFirstIndex(arr, target, 0));
        System.out.println("Last Index: " + findLastIndex(arr, target, arr.length - 1));
        System.out.println("Target Found: " + search(arr, target, 0));
    }

    // Find the first occurrence of the target value index.
    static int findFirstIndex(int[] arr, int target, int index){
        if(index == arr.length){
            return -1; // Target not found
        }
        if(arr[index] == target){
            return index;
        }
        return findFirstIndex(arr, target, index + 1);
    }

    // Find the last occurrence of the target value index.
    static int findLastIndex(int[] arr, int target, int index){
        if(index < 0){
            return -1; // Target not found
        }
        if(arr[index] == target){
            return index;
        }
        return findLastIndex(arr, target, index - 1);
    }

    // Return true if the target element is found, otherwise false.
    static boolean search(int[] arr, int target, int index){
        if(index == arr.length){
            return false;
        }
        return arr[index] == target || search(arr, target, index + 1);
    }
}
