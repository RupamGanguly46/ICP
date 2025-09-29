package Day_3;
import java.util.*;
public class LC_48_Rotate_image {
    public void rotate(int[][] matrix) {
        // For non-square matrices
        // int[][] ans = new int[matrix[0].length][matrix.length]

        int[][] original = new int[matrix.length][matrix.length];
        int r=0;
        while(r<matrix.length){
            original[r] = Arrays.copyOf(matrix[r], matrix[0].length);
            r++;
        }
        for(int i=0; i<matrix.length; i++){
            for(int k=0; k<matrix[0].length; k++){
                matrix[k][i] = original[matrix.length - i - 1][k];
            }
        }
    }
}