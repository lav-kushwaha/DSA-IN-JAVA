package Searching.LinearSearch;

import javax.xml.transform.stax.StAXResult;

public class LinearSearch {
    public static void main(String[] args) {
        int [] arr = {10,20,40,50,25,30};
        int target = 30;

        //here we will get the index of target element:
        int valueIndex = Search(arr,target);
        System.out.println(valueIndex);

        //Here, we will get the element.
        int element = LinearSearch2(arr,target);
        System.out.println(element);

        //Here, we will get true if target element is exist.
        //otherwise, it will return false.
        boolean ans = LinearSearch3(arr,target);
        System.out.println(ans);

    }
    //It will return target element index.
    //if target element is not found it it will return -1;
    static int Search(int arr [], int target){
        //for empty array.
        if(arr.length == 0){
            return -1;
        }
         for(int index=0;index<arr.length;index++){
             if(arr[index] == target){
                 return index;
             }
         }
         return -1;
    }

    //Search the target and return the element.
    static int LinearSearch2(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        //for-each loop for iterating every element.
        for(int element : arr){
            if(element == target){
                return element;
            }
        }
        return -1;
    }

    //Return true if target element is found otherwise return false.
    static boolean LinearSearch3(int[] arr, int target){
        if(arr.length == 0){
            return false;
        }
        //for-each loop for iterating every element.
        for(int element : arr){
            if(element == target){
                return false;
            }
        }
        return false;
    }
}
