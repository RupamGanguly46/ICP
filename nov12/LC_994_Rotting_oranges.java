import java.util.*;
public class LC_994_Rotting_oranges{
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < rows; i++){
            for(int j=0; j < cols; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[] {i, j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int time = 0;

        // up, down, right, left
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Levels iterations
        while(!q.isEmpty()){
            time++;
            int size = q.size();
            // Inside-level iterations
            for(int i = 0; i<size; i++){

                int[] orange = q.poll();
                
                // For each direction/neighbour
                for(int dir[]: dirs){
                    int x = orange[0] + dir[0];
                    int y = orange[1] + dir[1];

                    if(x<0 || x >= rows || y<0 || y >= cols || grid[x][y] ==2 || grid[x][y] == 0){
                        continue;
                    }

                    grid[x][y] = 2;

                    q.offer(new int[] {x,y});

                    fresh--;

                }
            }
        }

        return fresh == 0 ? time - 1 : -1;



    }
}
}