
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493_탑 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static Stack<int[]> stack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim(), " ");
		
		for (int i = 1; i <= N; i++) {
			int top = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek()[1] >= top) {
					sb.append(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			stack.push(new int[] {i, top}); // 방금 받은 값과 index 저장
		}

		System.out.println(sb);
	}

}
