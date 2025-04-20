package Questions.Questions;

class LuckyNum
{
    static boolean check(int n , int c){
        if(n<c){
            return true;
        }
        
        if(n%c==0){
            return false;
        }
        
         n=n-(n/c);
        return check(n, c+1);
    }
    public static boolean isLucky(int n)
    {
        // Your code here
     
        return check(n , 2);
    }
}