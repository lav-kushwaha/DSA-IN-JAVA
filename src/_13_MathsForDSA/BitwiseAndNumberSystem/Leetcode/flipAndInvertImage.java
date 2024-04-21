package _13_MathsForDSA.BitwiseAndNumberSystem.Leetcode;
import java.util.Arrays;
//https://leetcode.com/problems/flipping-an-image/description/
//832. Flipping an Image
public class flipAndInvertImage {
    public static void main(String[] args) {
        int [][] image = {
                        {1,1,0},
                        {1,0,1},
                        {0,0,0}
                        };
        int[][] output = flipAndInvertImages(image);
        for(int[] ans : output ){
           System.out.println(Arrays.toString(ans));
        }
    }
    public static int[][] flipAndInvertImages(int[][] image) {

        //First reverse each row
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[i].length/2;j++){
                int temp = image[i][j];
                image[i][j] = image[i][image[i].length-1-j];
                image[i][image[i].length-1-j] = temp;
            }
        }

        //XORing elements by 1 to invert the element.
        for(int row=0;row<image.length;row++){
            for(int col=0;col<image[row].length;col++){
                image[row][col] = image[row][col] ^ 1;
            }
        }
        return image;


        //2nd way.
//        int C = image[0].length;
//        for (int[] row: image)
//            for (int i = 0; i < (C + 1) / 2; ++i) {
//                int tmp = row[i] ^ 1;
//                row[i] = row[C - 1 - i] ^ 1;
//                row[C - 1 - i] = tmp;
//            }
//
//        return A;

    }
}
