import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15649_N_M_1 {

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
		makePermutation(0, 0);
		System.out.println(sb);
	}

	private static void makePermutation(int toChoose, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(map[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int j = 0; j < map.length; j++) {
			if (!visited[j]) {
				visited[j] = true;
				map[depth] = j + 1;
				makePermutation(toChoose, depth + 1);
				visited[j] = false;
			}
		}
	}

}
