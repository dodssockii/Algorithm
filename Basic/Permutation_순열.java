
import java.util.Arrays;

public class Permutation_순열 {

	static char[] src = { 'a', 'b', 'c', 'd' };

	public static void main(String[] args) {
		// N(src)개 중 M(3)개를 뽑아서 만들 수 있는 순열
		makePermutation(3, new char[3], new boolean[src.length]);
	}

	private static void makePermutation(int toChoose, char[] choosed, boolean[] visited) {
		if (toChoose == 0) {
			System.out.println(Arrays.toString(choosed));
			return;
		}

		for (int i = 0; i < src.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosed[choosed.length - toChoose] = src[i];
				makePermutation(toChoose - 1, choosed, visited);
				visited[i] = false;
			}
		}
	}

}
