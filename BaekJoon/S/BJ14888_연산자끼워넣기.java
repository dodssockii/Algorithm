import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888_연산자끼워넣기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, MAX, MIN;
	static int[] nums, opers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		opers = new int[4];

		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < 4; i++) {
			opers[i] = Integer.parseInt(st.nextToken());
		}

		MAX = Integer.MIN_VALUE;
		MIN = Integer.MAX_VALUE;
		dfs(1, nums[0], 0);
		sb.append(MAX).append("\n").append(MIN);
		System.out.println(sb);
	}

	private static void dfs(int idx, int value, int d) {
		if (idx == N) {
			MAX = Math.max(MAX, value);
			MIN = Math.min(MIN, value);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (opers[i] > 0) {
				opers[i]--;
				dfs(idx + 1, calulator(value, i, nums[d + 1]), d + 1); // i = 연산자
				opers[i]++;
			}
		}
	}

	private static int calulator(int value1, int i, int value2) { // i = 연산자
		if (i == 0) {
			return value1 + value2;
		} else if (i == 1) {
			return value1 - value2;
		} else if (i == 2) {
			return value1 * value2;
		} else {
			return value1 / value2;
		}
	}

}
