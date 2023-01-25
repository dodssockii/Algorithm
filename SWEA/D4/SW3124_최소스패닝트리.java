import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW3124_최소스패닝트리 {
    // MST - Kruskal
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, V, E; // V:정점의 개수, E:간선의개수

    static int[] parents;
    // Union-Find Algorithm
    private static void make(){
        parents = new int[V+1];
        for(int i=1; i<=V; i++){
            parents[i] = i;
        }
    }

    private static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
    static class Edge implements Comparable<Edge>{
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static Edge[] edgeList;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine().trim(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            edgeList = new Edge[E];

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine().trim(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(start, end, weight);
            }

            sb.append("#").append(t).append(" ");
            Arrays.sort(edgeList);
            make();

            int cnt = 0;
            long result = 0;
            for(Edge edge : edgeList){
                if(union(edge.start, edge.end)) {
                    result += edge.weight;
                    if (++cnt == V - 1) break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
