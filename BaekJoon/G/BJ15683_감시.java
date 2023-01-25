import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ15683_감시 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] map;
    static List<CCTV> cctvs;
    static int totalBlindSopt;

    // CCTV의 타입별 가능한 방향 정리
    // [type][돌린방향][그방향에서탐색가능한방향]
    // 방향 : 위:0, 아래:1, 우:2, 좌:3
    static int[][][] watchDirs = {
            {}, // 0번 CCTV
            {{0}, {1}, {2}, {3}}, // 1번 CCTV
            {{0, 1}, {2, 3}}, // 2번 CCTV
            {{0, 2}, {2, 1}, {3, 1}, {0, 3}}, // 3번 CCTV
            {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}}, // 4번 CCTV
            {{0, 1, 2, 3}}, // 5번 CCTV
    };
    static int MIN = Integer.MAX_VALUE;
    // 각 방향으로의 증분
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 위, 아래, 우, 좌

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cctvs = new ArrayList<>();
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine().trim());
            for(int c=0; c<M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c]>0 && map[r][c]<6){ // 1~5가 CCTV 번호
                    cctvs.add(new CCTV(r, c, map[r][c]));
                }else if(map[r][c]==0){
                    totalBlindSopt++;
                }
            }
        }

        // [CCTV{r=2, c=2, t=1}]
//        System.out.println(cctvs + " 기본 사각지대 : " + totalBlindSopt);
        dfs(0, 0);
        System.out.println(MIN);

    }

    static void dfs(int idx, int cleanSpot){
        if(idx==cctvs.size()){
            // 점검 완료 - 최소 영역 개수 반환
            MIN = Math.min(MIN, totalBlindSopt - cleanSpot);
            return;
        }

        // 현재 idx의 CCTV 가져오기
        CCTV cctv = cctvs.get(idx);

        // 가능한 방향으로 돌려보기
        for(int d=0; d<watchDirs[cctv.t].length; d++){
            // 해당 방향으로 색칠하기 -> 몇개나 색칠??
            int watched = scan(cctv, watchDirs[cctv.t][d], -1);
            dfs(idx+1, cleanSpot + watched);

            // 해당 방향 원복시켜주기
            scan(cctv, watchDirs[cctv.t][d], 1);

        }
    }

    // cctv 현재 CCTV, dirs 바라볼 수 있는 방향, flag 색칠 or 복구?, return 색칠한 개수
    private static int scan(CCTV cctv, int[] dirs, int flag){
        int cnt = 0;
        for(int d=0; d<dirs.length;d++){
            for(int i=1; ; i++){
                int nr = cctv.r + deltas[dirs[d]][0] * i;
                int nc = cctv.c + deltas[dirs[d]][1] * i;
                if(!isIn(nr, nc) || map[nr][nc] == 6) { // 영역 밖 또는 벽일 경우
                    break;
                }
                if(map[nr][nc]>0){ // cctv가 있다는 소리
                    continue;
                }
                if(map[nr][nc]==0){
                    cnt++;
                }
                map[nr][nc] += flag;
            }
        }
        return cnt;
    }

    private static boolean isIn(int r, int c){
        return 0<=r && r<N && 0<=c && c<M;
    }

    static class CCTV{
        int r, c, t;

        public CCTV(int r, int c, int t) {
            super();
            this.r = r;
            this.c = c;
            this.t = t;
        }

        @Override
        public String toString() {
            return "CCTV{" +
                    "r=" + r +
                    ", c=" + c +
                    ", t=" + t +
                    '}';
        }
    }
}
