package nov19;
import java.util.*;

public class graphIsAValidTree {
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();

            for(int i=0; i<n; i++){
                map.put(i, new ArrayList<>());
            }

            for(int i=0; i<edges.length; i++){
                int v1 = edges[i][0];
                int v2 = edges[i][1];

                map.get(v1).add(v2);
                map.get(v2).add(v1);
            }

            return BFT(map);
        }

        public boolean BFT(HashMap<Integer, List<Integer>> map){
                Queue<Integer> q = new LinkedList<>();
                HashSet<Integer> visited = new HashSet<>();
                int c = 0;
                for(int i: map.keySet()){
                    if(visited.contains(i)){
                        continue;
                    }
                    c++;
                    q.offer(i);
                    while(!q.isEmpty()){
                        // 1 Remove
                        int rm = q.poll();

                        // 2 Ignore
                        if(visited.contains(rm)){
                            return false;
                        }

                        // 3 Visit
                        visited.add(rm);

                        // 5 Add neighbours
                        for(int nbr: map.get(rm)){ 
                            if(!visited.contains(nbr)){
                                q.offer(nbr);
                            }
                        }
                    }
                }
                return c==1;
                
            }
    }
}
