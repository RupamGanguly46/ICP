package jan12new;

public class LC_695_Max_Area_of_Island {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int maxArea = 0;
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j]==1){
                        maxArea = Math.max(maxArea, sink(i, j, grid));
                    }
                }
            }
            return maxArea;
        }
        public int sink(int i, int j, int[][] grid){
            if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return 0;
            grid[i][j] = 0;
            return 1 + sink(i+1, j, grid) + sink(i-1, j, grid) + sink(i, j+1, grid) + sink(i, j-1, grid);
        }
    }
}
