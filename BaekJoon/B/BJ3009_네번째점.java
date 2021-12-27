import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3009_네번째점 {

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] x = new int[3];
		int[] y = new int[3];
		int nx, ny;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		if (x[1] == x[2])
			nx = x[0];
		else
			nx = (x[0] == x[1]) ? x[2] : x[1];

		if (y[1] == y[2])
			ny = y[0];
		else
			ny = (y[0] == y[1]) ? y[2] : y[1];

		System.out.println(nx + " " + ny);
	}

}
