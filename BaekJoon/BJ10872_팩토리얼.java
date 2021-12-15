import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10872_팩토리얼 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine().trim());
		System.out.println(fact(N));
	}

	public static int fact(int n) {
		if (n >= 1) {
			return n * fact(n - 1);
		} else {
			return 1;
		}
	}

}
