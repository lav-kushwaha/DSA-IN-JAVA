package _14_Recursion_Questions.Backtracking;
import java.util.ArrayList;

//https://leetcode.com/problems/unique-paths/description/
//62. Unique Paths I

public class Maze {
    public static void main(String[] args) {
//        System.out.println(count(3,3));
//         path("",3,3);
        System.out.println(pathRet("",3,3));

        System.out.println(pathRetDiagonal("",3,3));
    }

    //count the path.
    public static int count (int row,int col){
        //when any of row and col becomes 1 just return 1 bcs we found one possible ans.
        if(row == 1 || col==1){
            return 1;
        }

        int left = count(row-1,col);
        int right = count(row,col-1);

        return left+right;
    }


    //Finding path with direction where D is down and R is right.
    public static void path (String p,int row, int col){
        //when both of row and col becomes 1 just print the ans, we found our 1 path.
        if(row == 1 && col==1){
            System.out.println(p);
            return;
        }

        //rows and column is must be greater than 1.
        if(row>1){
            path(p+"D",row-1,col);
        }
        if(col>1) {
            path(p+"R",row,col-1);
        }
    }

    //path retun in arraylist.
    public static ArrayList<String> pathRet (String p,int row, int col){
        //when both of row and col becomes 1 just print the ans, we found our 1 path.
        if(row == 1 && col==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        if(row>1){
           ans.addAll(pathRet(p+"D",row-1,col));
        }
        if(col>1) {
            ans.addAll(pathRet(p+"R",row,col-1));
        }
        return ans;
    }

    //Diagonal-path retun in arraylist.
    public static ArrayList<String> pathRetDiagonal (String p,int row, int col){
        //when both of row and col becomes 1 just print the ans, we found our 1 path.
        if(row == 1 && col==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        if(row>1 && col>1){
            ans.addAll(pathRetDiagonal(p+"D",row-1,col-1));
        }

        if(row>1){
            ans.addAll(pathRetDiagonal(p+"V",row-1,col));
        }
        if(col>1) {
            ans.addAll(pathRetDiagonal(p+"H",row,col-1));
        }
        return ans;
    }
}
