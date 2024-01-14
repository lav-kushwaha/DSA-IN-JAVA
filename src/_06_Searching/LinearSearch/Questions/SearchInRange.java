package _06_Searching.LinearSearch.Questions;
public class SearchInRange {
    public static void main(String[] args) {
        int arr [] = {10,20,30,40,50,60};
        int target = 10;
        int ans = Search(arr,target,2,4);
        System.out.println(ans);
    }
    static int Search(int [] arr,int target,int start,int end){
        if(arr.length == 0){
            return -1;
        }
        for(int i=start;i<=end;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}
