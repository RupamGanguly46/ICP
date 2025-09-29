package Home_Assignment_3;
import java.util.*;
public class LC_54_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int total = matrix.length * matrix[0].length;
        int visited = 0;

        List<Integer> result = new ArrayList<>();

        while (visited < total) {
            // traverse left → right
            int col = left;
            while (col <= right && visited < total) {
                result.add(matrix[top][col]);
                visited++;
                col++;
            }
            top++;

            // traverse top → bottom
            int row = top;
            while (row <= bottom && visited < total) {
                result.add(matrix[row][right]);
                visited++;
                row++;
            }
            right--;

            // traverse right → left
            col = right;
            while (col >= left && visited < total) {
                result.add(matrix[bottom][col]);
                visited++;
                col--;
            }
            bottom--;

            // traverse bottom → top
            row = bottom;
            while (row >= top && visited < total) {
                result.add(matrix[row][left]);
                visited++;
                row--;
            }
            left++;
        }

        return result;
    }
}
