package Questions.Questions;

class SumOfSeries {
    public static long seriesSum(int n) {
        // code here
         return (long)(n)*(n+1)/2;
    }

    public static void main(String[] args) {
        long ans = seriesSum(10);
        System.out.println(ans);
    }
}