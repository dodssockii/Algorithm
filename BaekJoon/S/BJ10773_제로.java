import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ10773_제로 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine().trim());

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int m = Integer.parseInt(br.readLine().trim());
			if (m > 0) {
				stack.push(m);
			} else {
				stack.pop();
			}
		}

		int answer = 0;
		for (int i = 0; i < stack.size(); i++) {
			answer += stack.elementAt(i);
		}
		
		System.out.println(answer);
	}

}
