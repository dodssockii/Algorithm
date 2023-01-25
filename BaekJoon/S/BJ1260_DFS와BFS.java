import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1260_DFS와BFS {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, V; // 정점의 개수, 간선의 개수, 정점번호
    static int[][] map;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine().trim(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine().trim(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            map[i][j] = map[j][i] = 1;
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(V);
    }

    public static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");

        for(int i=1; i<N+1; i++){
            if(map[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp + " ");

            for(int i=1; i<N+1; i++){
                if(map[temp][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
