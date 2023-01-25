import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10430_나머지 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine().trim(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        sb.append((A+B)%C).append("\n")
                .append(((A%C) + (B%C))%C).append("\n")
                .append((A*B)%C).append("\n")
                .append(((A%C) * (B%C))%C);
        System.out.println(sb);
    }
}
