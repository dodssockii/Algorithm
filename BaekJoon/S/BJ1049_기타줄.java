import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1049_기타줄 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int min = Integer.MAX_VALUE;

		int[] pack = new int[M];
		int[] unit = new int[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			pack[i] = Integer.parseInt(st.nextToken());
			unit[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(pack);
		Arrays.sort(unit);
		
		min = Math.min(((N/6)+1)*pack[0], N*unit[0]);
		min = Math.min(min, ((N/6)*pack[0])+(N%6)*unit[0]);
		
		System.out.println(min);
	}
}
