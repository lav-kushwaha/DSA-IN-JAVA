package Questions.Questions;

class findSingle{
    static int findSingle(int n, int arr[]){
          // code here
        int single = 0;
        for(int i=0;i<n;i++){
            single = single ^ arr[i];
        }
        return single;
    }
}