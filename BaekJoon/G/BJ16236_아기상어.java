import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16236_아기상어 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N; // N:공간의 크기 NxN
    static int[][] map;
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int sharkMoveCnt = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];

        Shark shark = null;

        // 0:빈칸, 123456:칸에있는 물고기 크기, 9:아기상어 위치
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine().trim(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    shark = new Shark(i, j, 2, 0);
                    // 원래 상어가 있던 위치는 공백으로 바뀌어야 함
                    map[i][j] = 0;
                }
            }
        }

//        for(int [] i : map){
//            System.out.println(Arrays.toString(i));
//        }
//        System.out.println(shark);
        // 입력 완료

        bfs(shark);
        System.out.println(sharkMoveCnt);
    }

    static void bfs(Shark shark){
        Queue<Shark> queue = new LinkedList();
        boolean[][] visited = new boolean[N][N];

        // 초기화
        queue.offer(shark);
        visited[shark.row][shark.col] = true;

        // 물고기를 먹으려고 이동한 거리
        int depth = 0;
        // 상어가 먹을 물고기
        Fish target = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            // 현재 큐에 있는 녀석들만 돌리자
            while(size-- > 0){
                Shark head = queue.poll();

                // 자식 탐색
                for(int d=0; d<deltas.length; d++){
                    int nr = head.row + deltas[d][0];
                    int nc = head.col + deltas[d][1];

                    if(isIn(nr, nc) && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        // 물고기와의 크기를 바탕으로 실제로 이동 가능한지 확인
                        if(map[nr][nc] == 0 || map[nr][nc] == head.size){
                            queue.offer(new Shark(nr, nc, head.size, head.eatCnt));
                        }
                        // 아기상어가 물고리를 먹을 수 있다면? -> 바로 먹으면 안되고 우선 target에 넣어두고 나중에 비교해야함
                        else if(map[nr][nc] < head.size){
                            Fish fish = new Fish(nr, nc, map[nr][nc], depth+1);
                            if(target == null){
                                target = fish;
                            }else{
                                // target이 비어 있지 않다면 비교해주어야 함 -> compareTo를 이용하여
                                // 값이 0보다 작으면 target, 크거면 fish를 target에 넣는다
                                target = target.compareTo(fish) < 0 ? target : fish;
                            }
                        }
                    }
                }
            }// size만큼 -> 현재의 depth 처리 완료
            // 이 시점에서 먹을 것이 발견되었다면 먹으러 가면 됨
            if(target != null){
                break;
            }
            depth++;
        }// queue가 완전히 빈 상태 또는 break된 상태
        // 먹을게 있나 없나
        if(target == null){
            return;
        }else{
            // 물고기 먹음
            shark.eat();
            // 먹은 자리는 정리
            map[target.row][target.col] = 0;
            // 물고리를 먹으로 이동한 거리 추기
            sharkMoveCnt += target.dist;
            // 상어가 물고리를 먹은 자리에서 새로운 bfs 탐색
            bfs(new Shark(target.row, target.col, shark.size, shark.eatCnt));
        }
    }

    static boolean isIn(int r, int c){
        return 0<=r && r<N && 0<=c && c<N;
    }

    static class Shark{
        int row, col, size, eatCnt;

        public Shark(int row, int col, int size, int eatCnt) {
            this.row = row;
            this.col = col;
            this.size = size;
            this.eatCnt = eatCnt;
        }

        public void eat(){
            eatCnt++;
            if(size==eatCnt){
                this.size++;
                eatCnt = 0;
            }
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "row=" + row +
                    ", col=" + col +
                    ", size=" + size +
                    ", eatCnt=" + eatCnt +
                    '}';
        }
    }

    static class Fish implements Comparable<Fish>{
        int row, col, size, dist;

        public Fish(int row, int col, int size, int dist) {
            this.row = row;
            this.col = col;
            this.size = size;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if(this.dist == o.dist){
                if(this.row == o.row){
                    // 3순위 정렬 기준 : 왼쪽, col이 가장 작은 것
                    return Integer.compare(this.col, o.col);
                }else{
                    // 2순위 정렬 기준 : 위쪽, row가 가장 작은 것
                    return Integer.compare(this.row, o.row);
                }
            }else{
                // 1순위 정렬 기준 : 거리가 가장 짧은 것
                return Integer.compare(this.dist, o.dist);
            }
        }
    }
}
