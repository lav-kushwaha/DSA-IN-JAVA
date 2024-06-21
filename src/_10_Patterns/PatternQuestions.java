package Pattern;

public class PatternQuestions {
    public static void main(String[] args) {
//        pattern(4);
//        pattern1(4);
//        pattern2(5);
//        pattern3(5);
//          pattern4(5);
//          pattern5(5);
        pattern6(5);
    }

    public static void pattern(int n){
        for(int row = 1; row<=n;row++){
            for(int column = 1; column<=n; column++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }

    //pattern 01
   public static void pattern1(int n){
        for(int row = 1; row<=n;row++){
            for(int column = 1; column<=row; column++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
   }
    public static void pattern2(int n){
        for(int row = n; row>=0;row--){
            for(int column = 1; column<=row; column++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }

    public static void pattern3(int n){
        for(int row = 1; row<=n;row++){
            for(int column = 1; column<=row; column++){
                System.out.print(column+ " ");
            }
            System.out.println(" ");
        }
    }

    public static void pattern4(int n){
        for(int row = 1; row<=n;row++){
            for(int column = 1; column<=row; column++){
                System.out.print(column+ " ");
            }
            System.out.println(" ");
        }
    }

    public static void pattern5(int n){
        for(int row = 1; row<=n;row++){
            for(int column = 1; column<=row; column++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
        for(int row1 = 4; row1>=0;row1--){
            for(int column1 = 1; column1<=row1; column1++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    public static void pattern6(int n){
        for(int row = 1; row<=n;row++) {
            //spaces
            for(int col = 0; col<n-row; col++){
                System.out.print("  ");
            }
            for(int col = row; col>=1; col--){
                System.out.print(col+" ");
            }
            for(int col = 2; col<=row; col++){
                System.out.print(col+" ");
            }
            System.out.println(" ");
        }
    }

}
