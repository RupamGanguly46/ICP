package jan2new;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC_1631_Path_with_minimum_effort {
    // Using Graph Class
    class Solution1 {
        class Graph{
            HashMap<Integer, HashMap<Integer, Integer>> map;
            Graph(int v){
                map = new HashMap<>();
                for(int i=0; i<v; i++) map.put(i, new HashMap<>());
            }
            void addEdge(int v1, int v2, int cost){
                map.get(v1).put(v2, cost);
                map.get(v2).put(v1, cost);
            }
        }
        public int minimumEffortPath(int[][] heights) {
            // heights is array of arrays, all have to be of same size, it's not arraylist!
            int rows = heights.length;
            int cols = heights[0].length;
            Graph g = new Graph(rows*cols);

            // down, up, right, left
            int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    int v1 = i*cols + j;

                    for(int[] d: dirs){
                        int ni = i + d[0];
                        int nj = j + d[1];

                        // Skip impossible direction
                        if(ni<0 || ni>=rows || nj<0 || nj>=cols) continue;

                        int v2 = ni*cols + nj;
                        int cost = Math.abs(heights[i][j] - heights[ni][nj]);

                        g.addEdge(v1, v2, cost);
                    }

                }
            }

            int[] SD = new int[rows*cols];
            // We fill with max values as we compare it will smaller numbers and find smallest number
            Arrays.fill(SD, Integer.MAX_VALUE);
            dijkstra(0, g, SD);
            return SD[rows*cols-1];
        }
        class Pair{
            int node;
            int pathdis;
            Pair(int node, int pathdis){
                this.node = node;
                // Tracking maximum effort of path
                this.pathdis = pathdis;
            }
        }
        // We find minimum effort route
        public void dijkstra(int src, Graph g, int[] SD){
            // src to src = Math.abs(height[src]-height[src])= 0
            SD[src] = 0;

            // To chose route first freedily with minimum effort
            PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.pathdis - b.pathdis
            );
            
            pq.add(new Pair(src, 0));

            while(!pq.isEmpty()){
                // Remove
                Pair rm = pq.poll();
                // Ignore
                if(rm.pathdis > SD[rm.node]) continue;

                // Adding neighbours
                for(int nbr: g.map.get(rm.node).keySet()){
                    int edgecost = g.map.get(rm.node).get(nbr);
                    int maxCostTillNow = rm.pathdis;
                    int newCost = Math.max(edgecost, maxCostTillNow);

                    // Ignoring nbrs, just like !vis.contains
                    if(newCost < SD[nbr]){
                        SD[nbr] = newCost;
                        pq.add(new Pair(nbr, newCost));
                    }
                }
            }
        }
    }

    // Without using Graph class, directly using heights array
    class Solution2 {
        class Pair{
            int r;
            int c;
            int pathdis;
            Pair(int r, int c, int pathdis){
                this.r = r;
                this.c = c;
                this.pathdis = pathdis;
            }
        }
        public int minimumEffortPath(int[][] heights) {
            int rows = heights.length;
            int cols = heights[0].length;

            int[][] SD = new int[rows][cols];

            for(int[] a : SD){
                Arrays.fill(a, Integer.MAX_VALUE);
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.pathdis - b.pathdis
            );

            SD[0][0] = 0;

            pq.offer(new Pair(0, 0, 0));

            int[][] dirs = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
            };

            while(!pq.isEmpty()){
                Pair rm = pq.poll();

                if(rm.pathdis > SD[rm.r][rm.c]) continue;

                if(rm.r == rows-1 && rm.c == cols-1) return rm.pathdis;

                for(int d[] : dirs){
                    int nr = rm.r + d[0];
                    int nc = rm.c + d[1];

                    if(nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                    int edgecost = Math.abs(heights[rm.r][rm.c] - heights[nr][nc]);
                    // rm.pathdis is the cost of path till now, and edgecost is the cost of next part of path
                    // We find maximum of them to find max cost of the whole path which is the effort of the path
                    int maxcost = Math.max(rm.pathdis, edgecost);

                    if(maxcost < SD[nr][nc]){
                        SD[nr][nc] = maxcost;
                        pq.offer(new Pair(nr, nc, maxcost));
                    }
                }

            }

            return 0;
        }
    }

    // Best solution : Dijkstra + Binary Search
    class Solution3 {
        private int n;
        private int m;
        private boolean[][] vis;
        private int[][] hs;
        public int minimumEffortPath(int[][] hs) {
            this.hs = hs;
            n = hs.length;
            m = hs[0].length;
            int l = 0;
            int r = 1000000;
            int res = r, mid;
            while(l <= r){
                mid = (l + r) / 2;
                vis = new boolean[n][m];
                if(hasPath(0, 0, mid)){
                    res = Math.min(res, mid);
                    r = mid - 1;
                } else 
                    l = mid + 1;
            }
            return l;
        }

        private boolean hasPath(int r, int c, int k){
            if(r == n - 1 && c == m - 1)
                return true;

            vis[r][c] = true;
            if(c + 1 < m && !vis[r][c + 1] && Math.abs(hs[r][c + 1] - hs[r][c]) <= k && hasPath(r, c + 1, k))
                return true;
                    
            if(r + 1 < n && !vis[r + 1][c] && Math.abs(hs[r + 1][c] - hs[r][c]) <= k && hasPath(r + 1, c, k))
                return true;
                    
            if(c - 1 >= 0 && !vis[r][c - 1] && Math.abs(hs[r][c - 1] - hs[r][c]) <= k && hasPath(r, c - 1, k))
                return true;
                    
            if(r - 1 >= 0 && !vis[r - 1][c] && Math.abs(hs[r - 1][c] - hs[r][c]) <= k && hasPath(r - 1, c, k))
                return true;

            return false;
        }
    }
}
