public class DFSArrayGraph {
    static int[][] static_graph;
    static boolean[] static_visited;
    public static void main(String[] args) {
        int[][] graph =
                {{0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}};
        static_graph = graph;
        boolean[] visited = new boolean[graph.length];
        static_visited = visited;

        DFS(0);
    }

    static void DFS(int start){
        static_visited[start] = true;
        System.out.print("["+start+"]" + " ");
        for(int i =0; i < static_graph[start].length; i++){
            if(!static_visited[i] && static_graph[start][i]==1){
                DFS(i);
            }
        }
    }
}
