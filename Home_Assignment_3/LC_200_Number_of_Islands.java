package Home_Assignment_3;

public class LC_200_Number_of_Islands {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                // If island found:
                if(grid[i][j]=='1'){
                    count++;
                    sink(grid, i, j);
                }
            }
        }
        return count;
    }
    public void sink(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        // Top:
        sink(grid, i-1, j);
        // Bottom:
        sink(grid, i+1, j);
        // Left:
        sink(grid, i, j-1);
        // Right:
        sink(grid, i, j+1);
    }
}