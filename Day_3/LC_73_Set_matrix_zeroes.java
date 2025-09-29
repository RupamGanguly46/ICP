package Day_3;
import java.util.*;
public class LC_73_Set_matrix_zeroes {
    public void setZeroes(int[][] matrix) {
        int[][] originalMatrix = new int[matrix.length][matrix[0].length];
        for(int r=0; r<matrix.length; r++){
            originalMatrix[r] = Arrays.copyOf(matrix[r], matrix[0].length);
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(originalMatrix[i][j]==0){
                    int k=0;
                    // For both row and column values together
                    while(k<matrix.length && k<matrix[0].length){
                        matrix[i][k] = 0;
                        matrix[k][j] = 0;
                        k++;
                    }
                    // For remaining (either row values or column values)
                    // For same column, and changing rows
                    while(k<matrix.length){
                        matrix[k][j] = 0;
                        k++;
                    }
                    // For fixed row, and changing columns
                    while(k<matrix[0].length){
                        matrix[i][k] = 0;
                        k++;
                    }
                }
            }
        }
    }
}