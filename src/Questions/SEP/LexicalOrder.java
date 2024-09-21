package Questions.SEP;
import java.util.*;

//https://leetcode.com/problems/lexicographical-numbers/
//386. Lexicographical Numbers

class LexicalOrder {
    public static List<Integer> lexicalOrder(int n) {
         List<Integer> result = new ArrayList<>();
         for(int num = 1; num<=9;num++)
         helper(num,n,result);
         return result;
    }

    //Dfs
    public static void helper(int curr, int n, List<Integer> result){
        if(curr>n) return;
        result.add(curr);
        for(int append = 0; append<=9;append++){
            int newNum = curr * 10 + append;
            if(newNum > n) return;
            helper(newNum,n,result);
        }
    }

    public static void main(String[] args) {
        int n = 13;
        List<Integer> ans = lexicalOrder(n);
        System.out.println(ans);
    }
}