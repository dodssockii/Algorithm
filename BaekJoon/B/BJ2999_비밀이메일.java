import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2999_비밀이메일 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static char[][] map;
    static int R,C;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int size = str.length();
        int maxR = Integer.MIN_VALUE;
        for(int i=1; i<size; i++){
            if(size%i==0 && i<=size/i){
                R = i;
                C = size / i;
            }
        }

        int cnt = 0;
        map = new char[R][C];
        for(int i=0; i<C; i++){
            for(int j=0; j<R; j++){
                map[j][i] = str.charAt(cnt);
                cnt++;
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(map[i][j]);
            }
        }
        System.out.println(sb);
//
//        for(int i=0; i<R; i++){
//            for(int j=0; j<C; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
