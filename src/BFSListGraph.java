import java.util.*;

public class BFSListGraph {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;
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

        int shortest = 0;
//        for(int i =1 ; i <= 3(높이길이 - 행의 개수); i++){
//            for(int j =1; j <= 5(가로길이 - 열의개수); j++){
////                1)시작노드표현식(1): (i-1)*5(열의 개수) + j
////                2)타겟의 번호와 타겟의 유효성(2);
////                  2-1) 타켓의 번호 j를 -1빼면 왼쪽, j를 +1하면 오른쪽, i+1하면 아래, i-1하면 위쪽
////                  2-2) i와 j가 상화좌우 길이 체크
////                상하좌우 체크 로직
//                int[] dx = {-1,1,0,0};
//                int[] dy = {0,0,-1,1};
//                for(int d =0; d<4; d++){
//                    int target_i = i+dx[d];
//                    int target_j = i+dy[d];
//                    if(target_i>=1 && target_i<=3 && target_j >=1 && target_j <= 5){
//                        addEdge((i-1)*5 + j, (target_i-1)*5x + target_j);
//                    }
//                }
//            }

            distance = new int[node_n];

            System.out.println(BFS(0, 2));

    }

    static void addEdge(int a, int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    static int BFS(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int next = queue.poll(); // 방문
            for (int a : adjList.get(next)) {
                if (!visited[a]) {
                    queue.add(a);  //방문예정인 데이터를 큐에 담는것.
                    distance[a] = distance[next] + 1;
                    visited[a] = true;
                    if (visited[target]) {
                        return distance[target];
                    }
                }
            }

        }
        return -1;
    }
}

