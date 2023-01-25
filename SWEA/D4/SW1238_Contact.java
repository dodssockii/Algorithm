import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SW1238_Contact {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, start;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        // 10개의 테스크 케이스가 주어짐
        for(int t=1; t<=10; t++){
            st = new StringTokenizer(br.readLine().trim(), " ");
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            map = new int[101][101];
            st = new StringTokenizer(br.readLine().trim(), " ");
            for(int i=0; i<N/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from][to] = 1;
            }

            int answer = bfs();
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];

        // 출발점
        queue.offer(start);
        visited[start] = true;

        // 쭉 돌리면 안됨 depth 별로 파악을 해야하기 때문에 현재 정점이 바라볼 수 있는 만큼만 돌려야함
        int maxNum = 0; // 각각의 턴에 대해서 최대값
        while(!queue.isEmpty()){
            int size = queue.size(); // 현재 queue에 담겨 있는 것들 구함
            maxNum = 0;
            while (size-- > 0){
                // 대장 가져오기
                Integer head = queue.poll();
                maxNum = Math.max(maxNum, head);

                // 자식 찾기
                for(int c=1; c<101; c++){
                    if(map[head][c] == 1 && !visited[c]){
                        queue.offer(c);
                        visited[c] = true;
                    }
                }
            }
        }
        return maxNum;
    }
}
