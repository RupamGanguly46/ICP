package jan21new;

import java.util.Arrays;

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

}
