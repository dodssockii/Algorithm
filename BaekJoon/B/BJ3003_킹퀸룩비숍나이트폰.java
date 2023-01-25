import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3003_킹퀸룩비숍나이트폰 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] map = new int[6];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine().trim(), " ");
        for(int i=0; i<6; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        sb.append(map[0]==1?0:(1-map[0])).append(" ");
        sb.append(map[1]==1?0:(1-map[1])).append(" ");
        sb.append(map[2]==2?0:(2-map[2])).append(" ");
        sb.append(map[3]==2?0:(2-map[3])).append(" ");
        sb.append(map[4]==2?0:(2-map[4])).append(" ");
        sb.append(map[5]==8?0:(8-map[5])).append(" ");

        System.out.println(sb);
    }
}
