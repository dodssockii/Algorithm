import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15650_N과M2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N];
		visited = new boolean[N];
		makeCombination(0, 1);
		System.out.println(sb);
	}

	private static void makeCombination(int depth, int startIdx) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(map[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = startIdx; i <= map.length; i++) {
			if (!visited[depth]) {
				visited[depth] = true;
				map[depth] = i;
				makeCombination(depth + 1, i + 1);
				visited[depth] = false;
			}
		}
	}
}
