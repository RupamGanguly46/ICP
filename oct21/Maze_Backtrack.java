package oct21;
import java.util.*;
public class Maze_Backtrack {
    public static void main(String[] args) {
        int[][] maze = new int[3][3];
        for(int[] i: maze){
            Arrays.fill(i, -1);
        }
        fun(0, 0, maze, 1);
    }
    private static void fun(int r, int c, int[][] maze, int count){
        if(r==maze.length-1 && c==maze[0].length - 1){
            maze[r][c] = count;

            // Print maze
            for(int i=0; i<maze.length; i++){
                for(int j=0; j<maze[0].length; j++){
                    System.out.print(maze[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();

            // Backtrack when returning from answer
            maze[r][c] = -1;

            return;
        }
        
        if(maze[r][c]!=-1){
            return;
        }

        maze[r][c] = count;

        if(c<maze[0].length-1){
            fun(r, c+1, maze, count+1);
        }

        if(c>0){
            fun(r, c-1, maze, count+1);
        }

        if(r<maze.length-1){
            fun(r+1, c, maze, count+1);
        }

        if(r>0){
            fun(r-1, c, maze, count+1);
        }

        // Backtrack when all paths searched and no answer, moving to previous function call/cell.
        maze[r][c] = -1;
    }
}
