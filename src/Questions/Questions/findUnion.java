package Questions.Questions;

import java.util.ArrayList;

class findUnion
{
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
         ArrayList<Integer> ans = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                if(i == 0 || arr1[i] != arr1[i - 1])
                    ans.add(arr1[i]);
                i++;
            }
            else if(arr1[i] > arr2[j]){
                if(j == 0 || arr2[j] != arr2[j - 1])
                    ans.add(arr2[j]);
                j++;
            }
            else{
                if((i == 0 || arr1[i] != arr1[i - 1]) && (j == 0 || arr2[j] != arr2[j - 1]))
                    ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        
        while(i < n){
            if(i == 0 || arr1[i] != arr1[i - 1])
                ans.add(arr1[i]);
            i++;
        }
        
        while(j < m){
            if(j == 0 || arr2[j] != arr2[j - 1])
                ans.add(arr2[j]);
            j++;
        }
        
        return ans;
    }
}