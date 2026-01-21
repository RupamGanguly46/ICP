package jan21new;

import java.util.Arrays;
import java.util.HashMap;

public class LC_1334_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {
    class Solution {
        public void bellmanFord(int src, int[][] edges, int[] dis, int n, int distanceThreshold){
            Arrays.fill(dis, Integer.MAX_VALUE);
            dis[src] = 0;

            // i = iteration (n-1)
            for(int i=0; i<n-1; i++){
                boolean updated = false;

                for(int[] edge : edges){
                    int u = edge[0];
                    int v = edge[1];
                    int wt = edge[2];
                    
                    if(dis[u] == Integer.MAX_VALUE) continue;

                    if(dis[u] + wt < dis[v]){
                        dis[v] = dis[u] + wt;
                        updated = true;
                    }
                }

                if(!updated) break;
            }
        }

        public int findTheCity(int n, int[][] edges, int distanceThreshold) {

            // convert undirected edges to directed edges
            int[][] directedEdges = new int[edges.length * 2][3];
            int idx = 0;
            for(int[] e : edges){
                directedEdges[idx++] = new int[]{e[0], e[1], e[2]};
                directedEdges[idx++] = new int[]{e[1], e[0], e[2]};
            }

            int minCount = Integer.MAX_VALUE;
            int city=0;
            for(int src=0; src<n; src++){
                int[] dis = new int[n];
                bellmanFord(src, directedEdges, dis, n, distanceThreshold);

                int count = 0;
                // It's optional to exclude the src itself as all other cities will also count themselves, thus comparision will remain unchanged.
                for(int nbr=0; nbr<n; nbr++){
                    if(dis[nbr] <= distanceThreshold && nbr != src) count++;
                }

                // If we take count<mincount, then we take the smallest city only
                // If we take condition count<=mincount, then the greater city updates it

                if(count<=minCount){
                    minCount = count;
                    city = src;
                }
            }

            return city;
        }
    }

    class Solution2 {
        class Graph{
            HashMap<Integer, HashMap<Integer, Integer>> map;
            Graph(int v){
                map = new HashMap<>();
                for(int i=0; i<v; i++) map.put(i, new HashMap<>());
            }
            void addEdge(int v1, int v2, int wt){
                map.get(v1).put(v2, wt);
                map.get(v2).put(v1, wt);
            }
        }
        public void bellmanFord(int src, Graph g, HashMap<Integer, Integer> dis, int n, int distanceThreshold){
            for(int i=0; i<n; i++) dis.put(i, Integer.MAX_VALUE);
            dis.put(src, 0);

            // i = iteration (n-1)
            for(int i=0; i<n-1; i++){
                boolean updated = false;

                for(int u=0; u<n; u++){
                    if(dis.get(u) == Integer.MAX_VALUE) continue;
                    if(dis.get(u) > distanceThreshold) continue;

                    for(int v: g.map.get(u).keySet()){
                        int wt = g.map.get(u).get(v);

                        if(dis.get(u) + wt < dis.get(v)){
                            dis.put(v, dis.get(u) + wt);
                            updated = true;
                        }
                    }
                }

                if(!updated) break;
            }
        }
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            Graph g = new Graph(n);
            for(int[] arr : edges){
                g.addEdge(arr[0], arr[1], arr[2]);
            }

            int minCount = Integer.MAX_VALUE;
            int city=0;
            for(int src=0; src<n; src++){
                HashMap<Integer, Integer> dis = new HashMap<>();
                bellmanFord(src, g, dis, n, distanceThreshold);

                int count = 0;
                // It's optional to exclude the src itself as all other cities will also count themselves, thus comparision will remain unchanged.
                for(int nbr=0; nbr<n; nbr++){
                    if(dis.get(nbr) <= distanceThreshold && nbr != src) count++;
                }

                // If we take count<mincount, then we take the smallest city only
                // If we take condition count<=mincount, then the greater city updates it

                if(count<=minCount){
                    minCount = count;
                    city = src;
                }
            }

            return city;
        }
    }

}
