import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1012_유기농배추 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int T, M, N, K; // T : 테스트케이스
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이
			K = Integer.parseInt(st.nextToken()); // 배추가 심어져있는 위치 개수

			map = new int[M][N];
			visited = new boolean[M][N];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}

			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.offer(new int[] { x, y });
		while (!queue.isEmpty()) {
			x = queue.peek()[0];
			y = queue.peek()[1];
			visited[x][y] = true;

			queue.poll();
			for (int d = 0; d < dx.length; d++) {
				int new_x = x + dx[d];
				int new_y = y + dy[d];

				if (new_x >= 0 && new_y >= 0 && new_x < M && new_y < N && !visited[new_x][new_y]
						&& map[new_x][new_y] == 1) {
					queue.offer(new int[] { new_x, new_y });
					visited[new_x][new_y] = true;
				}
			}
		}
	}

}
