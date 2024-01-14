package _07_Searching.LinearSearch.Questions;

public class SearchInString {
    public static void main(String[] args) {
        String str = "lavkushwaha";
        char target = 's';
        boolean ans = Search(str,target);
        System.out.println(ans);
    }
    static boolean Search(String str, char target){

        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == target){
                return true;
            }
        }
        return false;
    }

}
