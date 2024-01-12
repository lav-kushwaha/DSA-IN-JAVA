package _06_Introduction_To_Arrays_And_ArrayList.ArrayList;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(4);

        //adding element in arrayList
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);

        //removing element from list
        list.remove(2);//index no.2: 30 will be removed.

        //printing element
        System.out.println(list);

    }
}
