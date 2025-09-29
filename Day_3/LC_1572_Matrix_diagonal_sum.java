package Day_3;
public class LC_1572_Matrix_diagonal_sum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int len=mat.length;
        for(int m = 0; m<len; m++){
            for(int n=0; n<len; n++){
                if(m==n) sum+=mat[m][n];
                if(n==len-m-1) sum+=mat[m][n];
            }
        }
        if(len%2!=0){
            sum-=mat[len/2][len/2];
        }
        return sum;
    }
}