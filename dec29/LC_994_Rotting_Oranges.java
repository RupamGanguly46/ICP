package dec29;

import java.util.*;

public class LC_994_Rotting_Oranges {
    class Solution {
        public int orangesRotting(int[][] grid) {
            int count = 0, rows = grid.length, cols = grid[0].length;
            // ArrayDeque is faster than linkedlist!
            Queue<int[]> q = new ArrayDeque<>();

            // Add all initial rotten oranges to explore
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    if(grid[i][j]==2) q.add(new int[] {i, j});
                }
            }

            // Searching/Exploring/Expanding using BFS and rotting process
            while(!q.isEmpty()){
                
                // Storing qsize as directly using q.size() can cause wrong answer,
                // as size will keep changing during loop, and loop will end quickly.
                int qsize = q.size();

                // Exploring all rotten oranges together simultaneously in a given second
                for(int k=0; k<qsize; k++){
                    int[] rm = q.poll();
                    checkPutNbrs(q, grid, rm[0], rm[1], rows, cols);
                }
                if(!q.isEmpty()) count++;
            }

            // Checking if any orange left fine after rotting as much as possible
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    if(grid[i][j]==1) return -1;
                }
            }
            return count;
        }
        public void checkPutNbrs(Queue<int[]> q, int[][] grid, int i, int j, int rows, int cols){
            // If not rotten and position/index not out of bounds, then rot it
            // We check position first so we don't access wrong position
            // UP
            if(i>0 && grid[i-1][j]==1){
                grid[i-1][j] = 2;
                q.add(new int[] {i-1, j});
            }
            // DOWN
            if(i<rows-1 && grid[i+1][j]==1){
                grid[i+1][j] = 2;
                q.add(new int[] {i+1, j});
            }
            // LEFT
            if(j>0 && grid[i][j-1]==1){
                grid[i][j-1] = 2;
                q.add(new int[] {i, j-1});
            }
            // RIGHT
            if(j<cols-1 && grid[i][j+1]==1){
                grid[i][j+1] = 2;
                q.add(new int[] {i, j+1});
            }
        }
    }
}
