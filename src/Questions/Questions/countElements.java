package Questions.Questions;

class countElements
{
    public static int[] countElements(int a[], int b[], int n, int query[], int q)
    {
             int [] arr = new int[q];
        int count;
        for(int i=0;i<q;i++){
            count =0;
            for(int j=0;j<n;j++){
                if(a[query[i]]>=b[j]){
                    count++;
                }
            }
            arr[i] = count;
        }
        return arr;
    }
}