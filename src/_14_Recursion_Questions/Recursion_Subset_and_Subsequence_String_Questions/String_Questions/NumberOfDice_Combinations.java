package _14_Recursion_Questions.Recursion_Subset_and_Subsequence_String_Questions.String_Questions;
import java.util.ArrayList;

public class NumberOfDice_Combinations {
    public static void main(String[] args) {
//        DicePrint("",4);
        System.out.println(Dice("",4));
//        System.out.println(CountDice("",4));
    }

    //Dice Print.
    static void DicePrint(String p,int target){
        if(target==0){
            System.out.print(p+" ");
            return;
        }
        for(int i=1;i<=6&&i<=target;i++){
            DicePrint(p+i,target-i);
        }
    }

    //Dice.
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

    //count dice.
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

    //Dice Face.
    static void diceFace(String p, int target, int face) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= face && i <= target; i++) {
            diceFace(p + i, target - i, face);
        }
    }

    //DiceFace Return.
    static ArrayList<String> diceFaceRet(String p, int target, int face) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            list.addAll(diceFaceRet(p + i, target - i, face));
        }
        return list;
    }
}
