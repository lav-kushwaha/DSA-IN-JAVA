package _06_Intro_To_Arrays_And_ArrayList.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiDimensionalArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        //Created ArrayList for adding elements into the list.
        Scanner sc = new Scanner(System.in);

        //Initialisation
        for(int i=0;i<3;i++){
            list.add(new ArrayList<>());
        }

        //add elements.
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                list.get(i).add(sc.nextInt());
            }
        }

        System.out.println(list);
    }
}
