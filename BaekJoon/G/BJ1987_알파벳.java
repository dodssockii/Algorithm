import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1987_알파벳 {

    static int R, C;
    static int[][] map;
    static boolean[] visited = new boolean[26];
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);
        System.out.println(MAX);
    }

    public static void dfs(int r, int c, int cnt) {
        if (visited[map[r][c]]) {
            MAX = Math.max(MAX, cnt);
            return;
        } else {
            visited[map[r][c]] = true;
            for (int i = 0; i < deltas.length; i++) {
                int nr = r + deltas[i][0];
                int nc = c + deltas[i][1];

                if (isIn(nr, nc)) {
                    dfs(nr, nc, cnt + 1);
                }
            }
            visited[map[r][c]] = false;

        }
    }

    private static boolean isIn(int r, int c){
        return r<R && r>=0 && c<C && c>=0;
    }

}