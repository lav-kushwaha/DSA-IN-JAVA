package _14_Recursion_Questions.Leetcode;
import java.util.ArrayList;

public class NumberOfDice_Combination {
    public static void main(String[] args) {
//        DicePrint("",4);
        System.out.println(Dice("",4));
//        System.out.println(CountDice("",4));
    }
    static void DicePrint(String p,int target){
        if(target==0){
            System.out.print(p+" ");
            return;
        }
        for(int i=1;i<=6&&i<=target;i++){
            DicePrint(p+i,target-i);
        }
    }


    static ArrayList<String> Dice(String p,int target){
        if(target==0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i=1;i<=6&&i<=target;i++){
            list.addAll(Dice(p+i,target-i));
        }
        return list;
    }

    static int CountDice(String p,int target){
        if(target==0){
            return 1;
        }
        int count = 0;
        for(int i=1;i<=6&&i<=target;i++){
            count = count + CountDice(p+i,target-i);
        }
        return count;
    }
}
