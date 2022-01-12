
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15651_N_M_3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static int[] map;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N];
		dfs(0, 0);
		System.out.println(sb);
	}

	private static void dfs(int toChoose, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(map[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < map.length; i++) {
			map[depth] = i + 1;
			dfs(toChoose, depth+1);
		}
	}

}
