import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ10828_스택 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine().trim());

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			if (s.contains("push")) {
				st = new StringTokenizer(s, " ");
				String tmp = st.nextToken();
				int m = Integer.parseInt(st.nextToken());
				stack.push(m);
			} else if (s.equals("pop")) {
				if (stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
			} else if (s.equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if (s.equals("empty")) {
				if (stack.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			} else if (s.equals("top")) {
				if (stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.peek()).append("\n");
				}
			}
		}

		System.out.println(sb);
	}
}
