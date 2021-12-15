import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10817_세수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] mat = new int[3];
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		mat[0] = Integer.parseInt(st.nextToken());
		mat[1] = Integer.parseInt(st.nextToken());
		mat[2] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(mat);
		
		System.out.println(mat[1]);
	}
}
