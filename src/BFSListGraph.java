import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSListGraph {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] inputArr = {{0,1}, {0,2}, {1,3}, {2,3}, {2,4}};
        int node_n = 5;
        visited = new boolean[node_n];
        adjList = new ArrayList<>();
        for(int i =0; i < node_n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] a : inputArr){
            addEdge(a[0], a[1]);
        }

        BFS(0);
    }

    static void addEdge(int a, int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int next = queue.poll();
            System.out.print("["+next+"]" + " ");
            for (int target : adjList.get(next)){
                if(!visited[target]){
                    queue.add(target);
                    visited[target] = true;
                }
            }
        }
    }
}
