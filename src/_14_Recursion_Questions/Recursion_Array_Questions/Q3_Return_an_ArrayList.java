package _14_Recursion_Questions.Recursion_Array_Questions;
import java.util.ArrayList;

public class Q3_Return_an_ArrayList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,8};
        int target = 4;
        //Passing ArrayList as an arguments.
        //i.e, ArrayList<Integer> list = new ArrayList<>();
        System.out.println(FindIndexes(arr, target,0, new ArrayList<>()));//[3,4]
    }
     static ArrayList<Integer> FindIndexes(int[] arr, int target,int index, ArrayList<Integer> list) {
        if(index==arr.length){
            return list;
        }
        if(target == arr[index]){
            list.add(index);
        }
        return FindIndexes(arr, target,index+1,list);
     }
}
