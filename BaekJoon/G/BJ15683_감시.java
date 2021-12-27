
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ15683_감시 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	// CCTV 타입별 방향 전환
	static int[][][] watchDirs = { {}, // 0번
			{ { 0 }, { 1 }, { 2 }, { 3 } }, // 1번 상, 하, 우, 좌
			{ { 0, 1 }, { 2, 3 } }, // 2번
			{ { 0, 2 }, { 2, 1 }, { 1, 3 }, { 3, 0 } }, // 3번
			{ { 0, 1, 2 }, { 0, 1, 3 }, { 0, 2, 3 }, { 1, 2, 3 } }, // 4번
			{ { 0, 1, 2, 3 } } // 5번
	};

	static int R, C, MIN;
	static int[][] map;
	static List<CCTV> cctvs;
	static int whiteArea = 0; // 초기 상태 0의 개수

	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine().trim(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		cctvs = new ArrayList<>();
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] > 0 && map[r][c] < 6) { // CCTV
					cctvs.add(new CCTV(r, c, map[r][c]));
				} else if (map[r][c] == 0) {
					whiteArea++;
				}
			}
		}

//		System.out.println(whiteArea + " " + cctvs);
		MIN = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(MIN);
	}

	static void dfs(int cctvIdx, int clearSpot) {
		// 기저조건
		if (cctvIdx == cctvs.size()) {
			// 현 시점 최소 사각지대?
			MIN = Math.min(MIN, whiteArea - clearSpot);
			return;
		}

		CCTV cctv = cctvs.get(cctvIdx);
		for (int d = 0; d < watchDirs[cctv.t].length; d++) {
			int[] dirs = watchDirs[cctv.t][d]; // 회전 방향
			int scaned = scan(cctv, dirs, -1); // -1은 오염시킬거니까 flag값 -1로 줌

			dfs(cctvIdx + 1, clearSpot + scaned);

			// flag값 +1로 원상복구 해줘야 함
			scan(cctv, dirs, 1);
		}
	}

	// cctv : 사용할 CCTV, dirs : CCTV가 보는 방향, flag : 오염(-1), 원상복구(+1)
	static int scan(CCTV cctv, int[] dirs, int flag) {
		int cnt = 0;
		for (int d = 0; d < dirs.length; d++) {
			for (int i = 1;; i++) {
				int nr = cctv.r + deltas[dirs[d]][0] * i;
				int nc = cctv.c + deltas[dirs[d]][1] * i;
				if (!isIn(nr, nc) || map[nr][nc] == 6) {
					break;
				}
				if (map[nr][nc] > 0) {
					continue;
				}
				if (map[nr][nc] == 0) {
					cnt++;
				}
				// flag 값으로 인해 -1이 들어오면 나중에 원상복구 flag로 +1하면 다시 0이 됨
				map[nr][nc] += flag;
			}
		}
		return cnt;
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c & c < C;
	}

	static class CCTV {
		int r, c, t; // row, col, type

		CCTV(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public String toString() {
			return "CCTV [r=" + r + ", c=" + c + ", t=" + t + "]";
		}

	}

}
