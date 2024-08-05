package Questions;

import java.util.ArrayList;

class FindMissingInSecondArray {
    static ArrayList<Integer> findMissing(int a[], int b[], int n, int m)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int p = a[i];
            int q=0;
            for(int j=0;j<m;j++){
                if(b[j]==a[i]){
                    q=1;
                    break;
                }
            }
            if(q==0){
                ans.add(p);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] a = {1, 2, 3, 4, 5, 10};
        int b[] = {2, 3, 1, 0, 5};
        int n = 6;
        int m = 5;
        System.out.println(findMissing(a,b,n,m));
    }
}