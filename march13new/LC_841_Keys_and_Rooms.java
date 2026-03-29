import java.util.*;
class Solution {
    boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomsNumber = rooms.size();
        
        visited = new boolean[roomsNumber];
        visited[0] = true;
        
        visitRooms(0, rooms);

        for (boolean isVisited : visited) {
            if (isVisited == false) {
                return false;
            }
        }
        
        return true;
    }

    public void visitRooms(int roomNumber, List<List<Integer>> rooms) {
        List<Integer> keys = rooms.get(roomNumber);

        for (Integer key : keys) {
            if (visited[key] == false) {
                visited[key] = true;
                visitRooms(key, rooms);
            } 
        }
    }
}


