package _06_Intro_To_Arrays_And_ArrayList.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        //Syntax of ArrayList
        ArrayList<Integer> list = new ArrayList<Integer>(4);

        //Methods of ArrayList
        //adding element in arrayList
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);

        //removing element from list
        list.remove(2);//index no.2: 30 will be removed.

        //list.contains method gives true or false if number is present in the list the it will return true otherwise it will return false
        System.out.println(list.contains(40));//output:true

        //updating value using set : int index, int element
        list.set(0,100); //it will replace number from 0th index and put 100

        //if we have to get any items from list we can use get method
        int ans = list.get(1);//it will return index 1 element which is 20
        System.out.println(ans);

        //printing element
        System.out.println(list);


        //using for-loop taking input in arrays.
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lists = new ArrayList<>();

        //Taking user input in arraylist.
        for(int i=0;i<5;i++){
            lists.add(sc.nextInt());
        }
        //printing arraylist using for loops.
        for(int i=0;i<5;i++){
            System.out.print(lists.get(i));//pass index here, list[index] will not work.
        }

    }
}
