package Day_3;
public class LC_1351_count_negative_numbers_in_a_sorted_matrix {
        public int countNegatives(int[][] grid) {
        int negatives = 0;
        for(int m = 0; m < grid.length; m++){
            for(int n = 0; n < grid[0].length; n++){
                if(grid[m][n]<0) negatives++;
            }
        }
        return negatives;
    }
    // public static int countNegatives(int[][] grid) {
    //     int count = 0;
    //     // We start at diagonal elements and expand row wise and column wise
    //     for(int d=grid.length-1; d>=0; d--){
    //         // Loop for row
    //         int i = d;
    //         while(i>=0 && grid[d][i]<0){
    //             System.out.println(grid[d][i]);
    //             count++;
    //             i--;
    //         }
    //         // Loop for column
    //         int j = d-1;
    //         while(j>=0 && grid[j][d]<0){
    //             System.out.println(grid[j][d]);
    //             count++;
    //             j--;
    //         }
    //     }
    //     return count;
    // }
}