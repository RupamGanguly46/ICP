package Home_Assignment_3;

public class LC_74_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = binRow(matrix, target);
        if(r==-1){
            return false;
        }
        int c = binCol(matrix, target, r);
        if(c==-1){
            return false;
        }
        return true;
    }
    public int binRow(int[][] matrix, int target){
        int l = 0;
        int r = matrix.length-1;
        while(l<=r){
            int mid = l + (r - l) / 2;
            if(target<matrix[mid][0]){
                r = mid-1;
            }
            else if(target>matrix[mid][matrix[0].length-1]){
                l = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public int binCol(int[][] matrix, int target, int row){
        int l = 0;
        int r = matrix[0].length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(target==matrix[row][mid]){
                return mid;
            }
            else if(target<=matrix[row][mid]){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
    }
}