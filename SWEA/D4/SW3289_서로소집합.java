import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW3289_서로소집합 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, N, M; // N:집합의 개수, M:입력으로 주어지는 연산의 개수
    static int[] parents;

    public static void main(String[] args) throws IOException{
        T = Integer.parseInt(br.readLine().trim());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine().trim(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parents = new int[N+1]; // 1부터 시작
            make();
            sb.append("#").append(t).append(" ");

            // 0or1 a b 순으로 주어짐 a와 b는 N이하의 자연수이며 같을 수도 있음, 0은 합집합 1은 확인
            for(int m=0; m<M; m++){
                st = new StringTokenizer(br.readLine().trim(), " ");
                int zeroOne = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // zeroOne이 0이면 합집합 하라는 것이고, 1이면 합집합인지 확인하여 결과를 출력하라는 것
                if(zeroOne == 0){
                    union(a, b);
                }else{
                    int x = find(a);
                    int y = find(b);
                    if(x == y){
                        sb.append("1");
                    }else{
                        sb.append("0");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void make(){
        for(int n=1; n<=N; n++){
            parents[n] = n;
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
}
