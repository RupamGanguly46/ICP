import java.util.*;
public class graphAdjacencyList {
        public static class Edge{
            int src;
            int des;
            public Edge(int s, int d){
                this.src = s;
                this.des = d;
            }
    }

    public static void createGraph(ArrayList<Edge> arr[]){
        for(int i=0; i<arr.length; i++){
            arr[i] = new ArrayList<>();
        }

        arr[0].add(new Edge(0, 1));
        arr[0].add(new Edge(0, 2));

        arr[1].add(new Edge(1, 0));
        arr[1].add(new Edge(1, 3));

        arr[2].add(new Edge(2, 0));
        arr[2].add(new Edge(2, 4));

        arr[3].add(new Edge(3, 1));

        arr[4].add(new Edge(4, 2));

    }

    public static void BFS(ArrayList<Edge> arr[], int start, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr + " ");
                vis[curr] = true;

                for(int i=0; i<arr[curr].size(); i++){
                    Edge e = arr[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> arr[], boolean[] vis, int curr){
        System.out.println(curr + " ");
        vis[curr] = true;
        for(int i=0; i<arr[curr].size(); i++){
            Edge e = arr[curr].get(i);
            if(!vis[e.des]){
                DFS(arr, vis, e.des);
            }
        }
    }

    public static void printAllPaths(ArrayList<Edge> arr[], boolean[] vis, int curr, int target, String path){
        if(curr==target){
            path+=curr;
            System.out.println(path);
            return;
        }
        for(int i=0; i<arr[curr].size(); i++){
            Edge e = arr[curr].get(i);
            if(!vis[e.des]){
                vis[curr] = true;
                printAllPaths(arr, vis, e.des, target, path+curr);
                vis[curr] = false;
            }
        }
    }

    public static void main(String[] args){
        int V = 5;
        ArrayList<Edge> arr[] = new ArrayList[V]; 

        createGraph(arr);
        
        // Print neighbour of a given vertex
        for(int i=0; i<arr[0].size(); i++){
            Edge e = arr[0].get(i);
            System.out.println(e.des);
        }

        // Traverse over all nodes using BFS
        // boolean[] vis = new boolean[V];

        // for(int i=0; i<V; i++){
        //     if(vis[i]==false){
        //         BFS(arr, i, vis);
        //     }
        // }

        // Traverse all nodes using DFS
        // boolean[] vis = new boolean[V];
        // for(int i=0; i<V; i++){
        //     if(vis[i]==false){
        //         DFS(arr, vis, i);
        //     }
        // }

        // Print all paths
        boolean[] vis = new boolean[V];
        printAllPaths(arr, vis, 0, 4, "");
    }
}
