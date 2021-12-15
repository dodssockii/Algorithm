import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1874_스택수열 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine().trim());
		Stack<Integer> stack = new Stack<>();
		
		int m = 1; // stack에 들어갈 값

		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(br.readLine().trim()); // 주어진 값

			if (m <= t) {
				while (m <= t) {
					stack.push(m);
					m++;
					sb.append("+\n");
				}
			}
			if(t != stack.peek()) {
				System.out.println("NO");
				return;
			}
			for(int j=0; j<stack.size(); j++) {
				if(t<=stack.peek()) {
					stack.pop();
					sb.append("-\n");
				}else {
					break;
				}
			}
		}
		
		if(stack.size()==0) {
			System.out.println(sb);
		}
	}

}
