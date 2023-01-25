import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW5644_무선충전 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, M, BC;
    static User[] MA, MB; // A, B 사용자의 이동정보 배열

    // 이동 방향 - 이동안함, 상, 우, 하, 좌
    static int[][] dirs = {{0,0}, {-1, 0}, {0, 1}, {1,0}, {0, -1}};
    // 배터리 차처들
    static BatteryCharger[] spots;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine().trim());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine().trim(), " ");
            M = Integer.parseInt(st.nextToken());
            BC = Integer.parseInt(st.nextToken());

            MA = new User[M+1];
            MB = new User[M+1];

            // 사용자들의 최초 위치 (고정)
            MA[0] = new User(1, 1, 0);
            MB[0] = new User(10, 10, 0);

            updatePath(new StringTokenizer(br.readLine()), MA);
            updatePath(new StringTokenizer(br.readLine()), MB);

            // 배터리 차저에 대한 정보
            spots = new BatteryCharger[BC];

            for(int b = 0; b<BC; b++){
                st = new StringTokenizer(br.readLine());
                spots[b] = new BatteryCharger(st);
            }
            // 입력 완료
            // 각 시간별 충전 가능한 녀석 정보 업데이트
            checkCharger(MA);
            checkCharger(MB);
            // 충전
            int power = 0;
            power = charge();
            sb.append("#").append(t).append(" ").append(power).append("\n");
        }
        System.out.println(sb);
    }

    private static int charge(){
        int power = 0;
        for(int i=0; i<=M; i++){
            BatteryCharger bca = MA[i].chargers.poll();
            BatteryCharger bcb = MB[i].chargers.poll();

            // 둘다 없다면 현재시간에서는 할 게 없다.
            if(bca == null && bcb == null){
                continue;
            }else if(bca == null && bcb != null){
                power += bcb.power;
            }else if(bca != null && bcb == null) {
                power += bca.power;
            }else{ //  둘 다 있다면
                    if(bca.equals(bcb)){ // 혹시 둘이 같은가?
                        // 기본적으로 하나는 사용할것이므로
                        power += bca.power;
                        // 2인자를 찾아보자
                        BatteryCharger bca2 = MA[i].chargers.poll();
                        BatteryCharger bcb2 = MB[i].chargers.poll();
                        // 모두 다 2인자가 있다면 2인자중 큰놈
                        if(bca2 != null && bcb2 != null){
                            power += Math.max(bca2.power, bcb2.power);
                        }else {
                            // 한 녀석만 2인지가 있다면 한녀석 더해주기.
                            // 이인자가 없다면 그냥 통과
                            power += (bca2 == null? (bcb2==null? 0 : bcb2.power) : (bca2.power));
                        }
                    }else{ // 둘이 다름
                        power += (bca.power + bcb.power);
                    }
                }
        }
        return power;
    }

    private static void checkCharger(User[] users) {
        for(int i=0; i<=M; i++){
            // 해당 시간에서의 사용자 정보?
            User user = users[i];
            for(BatteryCharger bc: spots){
                // 충전 가능하다면 충전기를 추가해주자
                if(bc.canCharge(user)){
                    user.chargers.offer(bc);
                }
            }
        }
    }

    static void updatePath(StringTokenizer st, User[] users){
        for(int i=1; i<=M; i++){
            int dir = Integer.parseInt(st.nextToken());
            // 이전 사용자의 위치 + 새로운 좌표값
            User preUser = users[i-1];
            users[i] = new User(preUser.row + dirs[dir][0], preUser.col + dirs[dir][1], i);
        }
    }
    static class User{
        int row, col, time;
        // 가장 큰 것, 그 다음 것 찾기 위함
        PriorityQueue<BatteryCharger> chargers;

        public User(int r, int c, int t){
            this.row = r;
            this.col = c;
            this.time = t;
            this.chargers = new PriorityQueue<>();
        }
    }

    static class BatteryCharger implements Comparable<BatteryCharger>{
        int row, col, dist, power;

        public BatteryCharger(StringTokenizer st){
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            dist = Integer.parseInt(st.nextToken());
            power = Integer.parseInt(st.nextToken());
        }

        public boolean canCharge(User user){
            return (Math.abs(row - user.row) + Math.abs(col - user.col)) <= dist;
        }
        @Override
        // 우리가 필요한 것은 내림차순이므로
        public int compareTo(BatteryCharger o) {
            return Integer.compare(o.power, power) ;
        }

        @Override
        public String toString() {
            return "BatteryCharger{" +
                    "row=" + row +
                    ", col=" + col +
                    ", dist=" + dist +
                    ", power=" + power +
                    '}';
        }
    }
}
