package oct20;

public class Maze_Path_Count {
    public static void main(String[] args) {
        System.out.println(count(3, 3));
    }
    private static int count(int row, int col){
        if(row==1 || col==1){
            return 1;
        }
        
        return count(row-1, col) + count(row, col-1);
    }
}
