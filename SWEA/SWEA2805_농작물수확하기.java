import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2805_농작물수확하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] map;
	static int T, N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine().trim();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}
						
			int mid = N/2;
			int tmp = 0, answer = 0;
			for(int i=0; i<N; i++) {
				int st = mid - tmp;
				int la = mid + tmp;
				for(int j=st; j<=la; j++) {
					answer += map[i][j];
				}
				
				if(i>=mid) {
					tmp--;
				}else {
					tmp++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
}
