import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15663_N과M9 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] map;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine().trim(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N];

        st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);
        makePermutation(M, new int[M], new boolean[N]);
        System.out.println(sb);

    }

    private static void makePermutation(int toChoose, int[] choosed, boolean[] visited) {
        if(toChoose==0){
//            System.out.println(Arrays.toString(choosed));
            for(int i=0; i<M; i++){
                sb.append(choosed[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for(int i=0; i<N; i++){
            if(visited[i]){
                continue;
            } else if(before != map[i]) {
                visited[i] = true;
                choosed[choosed.length-toChoose] = map[i];
                before = map[i];
                makePermutation(toChoose - 1, choosed, visited);
                visited[i] = false;
            }
        }
    }
}
