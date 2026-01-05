package jan1new;

public class LC_1791_Find_Center_of_Star_Graph {
    class Solution {
        public int findCenter(int[][] edges) {
            for(int i=0; i<2; i++) for(int j=0; j<2; j++) if(edges[0][i] == edges[1][j]) return edges[1][j];
            return -1;
        }
    }
}
