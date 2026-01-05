package Winter_Bootcamp.Day1;
import java.util.*;
public class Searching_Graph {
    static class Graph{
        HashMap<Integer, HashMap<Integer, Integer>> map;

        Graph(int v){
            map = new HashMap<>();
            for(int i=0; i<v; i++){
                map.put(i, new HashMap<>());
            }
        }

        void addEdge(int v1, int v2, int cost){
            map.get(v1).put(v2, cost);
            map.get(v2).put(v1, cost);
        }
    }
    public boolean bfs(int src, int des, Graph g, HashSet<Integer> visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()){
            int rm = q.poll();

            if(visited.contains(rm)){
                continue;
            }

            visited.add(rm);

            if(rm==des) return true;

            for(int nbr: g.map.get(rm).keySet()){
                if(!visited.contains(nbr)){
                    q.offer(nbr);
                }
            }
        }
        return false;
    }
    public boolean dfs(int src, int des, Graph g, HashSet<Integer> visited){
        Stack<Integer> s = new Stack<>();
        s.push(src);
        while(!s.isEmpty()){
            int rm = s.pop();

            if(visited.contains(rm)){
                continue;
            }

            visited.add(rm);

            if(rm==des) return true;

            for(int nbr: g.map.get(rm).keySet()){
                if(!visited.contains(nbr)){
                    s.push(nbr);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Graph g = new Graph(7);
        HashSet<Integer> visited = new HashSet<>();

        Graph g = new Graph(7);
        g.addEdge(1, 4, 6);
        g.addEdge(1, 2, 10);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, 5);
        g.addEdge(4, 5, 1);
        g.addEdge(5, 6, 4);
        g.addEdge(6, 7, 3);
        g.addEdge(7, 5, 2);

        for(int v : g.map.keySet()){
            if(!visited.contains(v)){
                bfs
            }
        }

        
    }
}
