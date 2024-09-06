package Questions.SEP;
import java.util.Arrays;

//https://leetcode.com/problems/find-missing-observations/description/
//2028. Find Missing Observations

class FindMissingObservations {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean*(n+m);

        for(int i=0;i<m;i++){
            sum = sum - rolls[i];
        }
        
        if(sum<n || sum > 6*n) return new int[0];

        int avg = sum/n;
        int rem = sum%n;
        int res[] = new int[n];

        for(int i=0;i<n;i++){
            res[i] = avg;
            if(rem>0){
                res[i]++;
                rem--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int [] rolls = {3,2,4,3};
        int mean = 4;
        int n = 2;
        int arr [] = missingRolls(rolls,mean,n);
        System.out.println(Arrays.toString(arr));
    }
}