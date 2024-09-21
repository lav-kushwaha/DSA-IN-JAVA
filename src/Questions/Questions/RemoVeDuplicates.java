package Questions.Questions;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/remove-duplicates3034/0
//Remove Duplicates

class RemoVeDuplicates {
    static String removeDups(String str) {
        // code here
        ArrayList<Character> a = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(!a.contains(str.charAt(i))){
                a.add(str.charAt(i));
                ans.append(str.charAt(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDups("lavv"));
    }
}