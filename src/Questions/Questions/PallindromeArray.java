package Questions.Questions;

class PallindromeArray {
    public static boolean isPerfect(int[] arr) {
        // code here
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=arr[arr.length-i-1]) return false;
        }
        return true;
    }
}
