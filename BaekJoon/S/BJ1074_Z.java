import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1074_Z {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, R, C;
    static int A; // 목적지에 도달하면 반환할 최종 값 즉 닶

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        recursion(0, 0, (int)Math.pow(2, N));

    }

    private static void recursion(int r, int c, int len) {
        // 기저조건 - len길이가 1인 경우
        if(len == 1){
            // 목적지에 도달하면 그 값 반환
            if(r==R && c==C){
                System.out.println(A);
                System.exit(0); // 최종값을 출력했기 때문에 프로그램 종료, 이러지 않으면 다음 값 계속 탐색함
            }else{
                A++;
            }
            return;
        }

        // 영역 내부에 내가 찾으려는 지점이 없다면 그냥 곱하를 해버려도 됨
        // 이렇게 하지 않으면 시간초과가 뜸. 즉, 불필요한 연산을 줄여야 함
        if(!(r <= R && R < r+len && c <= C && C < c+len)){
            A += len * len;
            return;
        }

        // 4분할 탐색
        // 계속 len 길이를 절반으로 나누어 탐색함
        int next = len/2;
        recursion(r, c, next);
        recursion(r, c+next, next);
        recursion(r+next, c, next);
        recursion(r+next, c+next, next);
    }
}
