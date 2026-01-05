package jan1new;
import java.util.*;
public class LC_1311_Get_Watched_Videos_by_Your_Friends {
    // Using graph class
    class Solution1 {
        static class Graph{
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

        public List<String> watchedVideosByFriends(
                List<List<String>> watchedVideos,
                int[][] friends,
                int id,
                int level
        ) {

            Graph g = new Graph(friends.length);

            for(int i=0; i<friends.length; i++){
                for(int j=0; j<friends[i].length; j++){
                    g.addEdge(i, friends[i][j], 1);
                }
            }

            HashSet<Integer> vis = new HashSet<>();
            Queue<Integer> q = new ArrayDeque<>();

            q.offer(id);
            vis.add(id);

            int count = 0;

            // Multi Source BFS, as for next level, we check nbrs of all current persons.
            while(!q.isEmpty() && count < level){

                int qsize = q.size();

                for(int i=0; i<qsize; i++){
                    // Remove
                    int rm = q.poll();

                    // Adding neighbours
                    for(int nbr: g.map.get(rm).keySet()){
                        if(!vis.contains(nbr)){
                            vis.add(nbr);
                            q.offer(nbr);
                        }
                    }
                }

                // Increase current level for next neighbours
                count++;
            }

            // Now queue contains only persons at required level
            HashMap<String, Integer> freq = new HashMap<>();

            for(int rm : q){
                // Update frequencies
                for(String vid: watchedVideos.get(rm)){
                    int freqOfVideo = freq.getOrDefault(vid, 0);
                    freq.put(vid, freqOfVideo + 1);
                }
            }

            List<String> ans = new ArrayList<>(freq.keySet());
            ans.sort((a,b) -> {
                    if(!freq.get(a).equals(freq.get(b))) 
                        return freq.get(a).compareTo(freq.get(b));
                    return a.compareTo(b);
                }
            );

            return ans;
        }
    }
    // Optimal
    class Solution2 {
        public List<String> watchedVideosByFriends(
                List<List<String>> watchedVideos,
                int[][] friends,
                int id,
                int level
        ) {

            int n = friends.length;

            boolean[] vis = new boolean[n];
            Queue<Integer> q = new ArrayDeque<>();

            q.offer(id);
            vis[id] = true;

            int count = 0;

            // Multi Source BFS, as for next level, we check nbrs of all current persons.
            while(!q.isEmpty() && count < level){

                int qsize = q.size();

                for(int i = 0; i < qsize; i++){
                    // Remove
                    int rm = q.poll();

                    // Adding neighbours
                    for(int nbr : friends[rm]){
                        if(!vis[nbr]){
                            vis[nbr] = true;
                            q.offer(nbr);
                        }
                    }
                }

                // Increase current level for next neighbours
                count++;
            }

            // Now queue contains only persons at required level
            HashMap<String, Integer> freq = new HashMap<>();

            for(int rm : q){
                // Update frequencies
                for(String vid : watchedVideos.get(rm)){
                    int freqOfVideo = freq.getOrDefault(vid, 0);
                    freq.put(vid, freqOfVideo + 1);
                }
            }

            List<String> ans = new ArrayList<>(freq.keySet());
            ans.sort((a, b) -> {
                int fa = freq.get(a);
                int fb = freq.get(b);

                if (fa != fb) {
                    return fa - fb;
                }
                return a.compareTo(b);
            });

            return ans;
        }
    }
}
