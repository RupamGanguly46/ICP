package nov19;
import java.util.*;
public class graphAdjacencyMap {
    public static class Graph{
        HashMap<Integer, HashMap<Integer, Integer>> map;
        
        public Graph(int v){
            map = new HashMap<>();
            for(int i=1; i<=v; i++){
                map.put(i, new HashMap<>());
            }
        }

        public void addEdge(int v1, int v2, int cost){
            map.get(v1).put(v2, cost);
            map.get(v2).put(v1, cost);
        }

        public void addNode(int v){
            map.put(v, new HashMap<>());
        }

        public void removeEdge(int v1, int v2){
            map.get(v1).remove(v2);
            map.get(v2).remove(v1);
        }

        public void removeNode(int v){
            for(int nbr: map.get(v).keySet()){
                map.get(nbr).remove(v);
            }
            map.remove(v);
        }

        public boolean hasEdge(int v1, int v2){
            return map.get(v1).containsKey(v2);
        }

        public boolean hasNode(int v){
            return map.containsKey(v);
        }

        public int noOfEdges(){
            int sum = 0;
            for(int node: map.keySet()){
                sum += map.get(node).size();
            }
            return sum/2;
        }

        public void display(){
            for(int node: map.keySet()){
                System.out.println(node+" : "+map.get(node));
            }
        }

        public boolean wrongHasPath(int src, int des){
            if(src==des){
                return true;
            }
            for(int nbr: map.get(src).keySet()){
                return wrongHasPath(nbr, des);
            }
            return false;
        }

        public boolean hasPath(int src, int des, HashSet<Integer> visited){
            if(src==des){
                return true;
            }
            for(int nbr: map.get(src).keySet()){
                if(!visited.contains(nbr)){
                    visited.add(nbr);

                    boolean ans = hasPath(nbr, des, visited);
                    // If not found then let it search the next neighbour, not directly return false
                    if(ans){
                        return ans;   
                    }
                } 
            }
            return false;
        }

        // Visited nodes never unvisited and removed from path
        public void wrongPrintAllPath(int src, int des, HashSet<Integer> visited, String path){
            if(src==des){
                System.out.println(path);
                return;
            }
            for(int nbr: map.get(src).keySet()){
                if(!visited.contains(nbr)){
                    visited.add(nbr);
                    wrongPrintAllPath(nbr, des, visited, path+src);
                } 
            }
        }

        public void printAllPath(int src, int des, HashSet<Integer> visited, String path){
            if(src == des){
                System.out.println(path + des);
                return;
            }

            visited.add(src);

            for(int nbr : map.get(src).keySet()){
                if(!visited.contains(nbr)){
                    printAllPath(nbr, des, visited, path + src + " ");
                }
            }

            visited.remove(src);  // backtrack
        }

        public boolean BFS(int src, int des){
            Queue<Integer> q = new LinkedList<>();
            q.offer(src);
            HashSet<Integer> visited = new HashSet<>();
            while(!q.isEmpty()){
                // 1 Remove
                int rm = q.poll();

                // 2 Ignore
                if(visited.contains(rm)){
                    continue;
                }

                // 3 Visit
                visited.add(rm);

                // 4 Self Work
                if(rm==des){
                    return true;
                }

                // 5 Add neighbours
                for(int nbr: map.get(rm).keySet()){ 
                                                    // We check again so we do not add duplicates unnecessarily
                                                    // Even for cycle detection we do not need these duplicates
                                                    // When all will be visited, these duplicates will be again and again ignored and finally code will still finish
                                                    // It won't run infinitely, but BFS will get slow!
                    if(!visited.contains(nbr)){
                        q.offer(nbr);
                    }
                }
            }
            return false;
        }

        public boolean DFS(int src, int des){
            Stack<Integer> st = new Stack<>();
            st.push(src);
            HashSet<Integer> visited = new HashSet<>();
            while(!st.isEmpty()){
                int rm = st.pop();
                if(visited.contains(rm)){
                    continue;
                }
                visited.add(rm);
                if(rm==des){
                    return true;
                }
                for(int nbr: map.get(rm).keySet()){
                    if(!visited.contains(nbr)){
                        st.push(nbr);
                    }
                }
            }
            return false;
        }

    }
    
    public static void main(String[] args){
        Graph g = new Graph(7);
        g.addEdge(1, 4, 6);
        g.addEdge(1, 2, 10);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, 5);
        g.addEdge(4, 5, 1);
        g.addEdge(5, 6, 4);
        g.addEdge(6, 7, 3);
        g.addEdge(7, 5, 2);

        // g.display();
        // System.out.println(g.hasPath(1, 10, new HashSet<>()));
        
        g.printAllPath(1, 6, new HashSet<>(), "");


        
    }
}
