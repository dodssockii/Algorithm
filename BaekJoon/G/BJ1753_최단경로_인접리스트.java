import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1753_최단경로_인접리스트 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int V, E, S; // V:정점의 개수, E:간선의 개수, S:시작점
    static class LinkNode{
        int no; // 몇 번 정점으로 가는지
        int weight; // 가중치는 얼마인지
        LinkNode pre; // 이전 링크노드는 어디인지

        public LinkNode(int no, int weight, LinkNode pre) {
            this.no = no;
            this.weight = weight;
            this.pre = pre;
        }

        @Override
        public String toString() {
            return "LinkNode{" +
                    "no=" + no +
                    ", weight=" + weight +
                    ", pre=" + pre +
                    '}';
        }
    }
    //static int[][] graph;
    static LinkNode[] graph;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine().trim(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(br.readLine().trim());
//        graph = new int[V+1][V+1];
        graph = new LinkNode[V+1];

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine().trim(), " ");
            // u에서 v로 가는 가중치 w 간선 존재
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
//            graph[u][v] = w;
            graph[u] = new LinkNode(v, w, graph[u]);
        }

//        for(int[] row: graph){
//            System.out.println(Arrays.toString(row));
//        }
        dijkstra();
    }

    private static void dijkstra(){
        visited = new boolean[V+1];
        distance = new int[V+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0; // 시작점은 0

        int min = 0, current = 0;
        for(int i=0; i<V; i++){
            min = Integer.MAX_VALUE;
            for(int j=1; j<=V; j++){
                if(!visited[j] && min > distance[j]){
                    min = distance[j];
                    current = j;
                }
            }

            visited[current] = true;

//            for(int c=1; c<=V; c++){
//                if(!visited[c] && graph[current][c] != 0 && distance[c] > min+graph[current][c]){
//                    distance[c] = min + graph[current][c];
//                }
//            }
            // graph에 연결되어있는지 즉, graph[current][c] != 0 인지 물어보지 않도
            // 아래 Linknode를 부를 때 확인함
            LinkNode next = graph[current];
            while (next!=null){
                if(!visited[next.no] && distance[next.no]>distance[current] + next.weight){
                    distance[next.no] = distance[current] + next.weight;
                }
                next = next.pre;
            }
        }

        for(int i=1; i<=V; i++){
            sb.append(distance[i] == Integer.MAX_VALUE? "INF":distance[i]).append("\n");
        }
        System.out.println(sb);
    }
}
