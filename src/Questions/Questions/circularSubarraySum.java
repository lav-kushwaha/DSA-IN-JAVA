package Questions.Questions;

class circularSubarraySum{

    static int circularSubarraySum(int a[], int n) {
    
        int TotalSum = 0;
        int noCircular = kadanesAlgo(a,n);
          for(int i=0;i<n;i++){
            TotalSum += a[i];
           // a[i] = -1*a[i];
        }
        int Circular = TotalSum + Math.abs(MinkadanesAlgo(a,n));
        if(Circular == 0){
            return noCircular;
        }
        return Math.max(Circular,noCircular);
    }
    
    static int kadanesAlgo(int[] a,int n){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += a[i];
            max = Math.max(sum,max);
            if(sum<0){
                sum = 0;
            }
        }
        return max;
    }
    static int MinkadanesAlgo(int[] a,int n){
        int min = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += a[i];
            min = Math.min(sum,min);
            if(sum>0){
                sum = 0;
            }
        }
        return min;
    }
    
}
