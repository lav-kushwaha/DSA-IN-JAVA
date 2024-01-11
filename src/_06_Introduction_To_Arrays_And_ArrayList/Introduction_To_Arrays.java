package _06_Introduction_To_Arrays_And_ArrayList;

import java.util.Arrays;

public class Introduction_To_Arrays {
    public static void main(String[] args) {
        //Q:store 5 roll numbers
        int rnos1 = 23;
        int rnos2 = 55;
        int rnos3 = 18;

        //Syntax :
        //datatype[] variable_name = new datatype[size]
        //store 5 roll numbers :
        //int [] rnos = new int[5]
        //or directly
        int [] rnos = {23,12,45,32,15};

        int [] ros;//declaration of array. ros is getting defined in the stack
        ros = new int[5];//initialisation : actually here object is being created in the memory(heap)


        //String [] arr1 = new String[5];//[null, null, null, null, null]
        //int [] arr = new int[5];//[0, 0, 0, 0, 0]
        //arr[0] = 1;
        //int []  arr = {1,2,3,4,5};
        //System.out.println(Arrays.toString(arr));


    }
}

