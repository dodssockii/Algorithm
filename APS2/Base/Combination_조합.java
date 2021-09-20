
import java.util.Arrays;

public class Combination_조합 {

	static char[] src = { 'a', 'b', 'c', 'd' };

	public static void main(String[] args) {
		// N(src)개 중 M(3)개를 뽑아서 만들 수 있는 조합
		makeCombination(3, new char[3], 0);
	}

	private static void makeCombination(int toChoose, char[] choosed, int startIdx) {
		if (toChoose == 0) {
			System.out.println(Arrays.toString(choosed));
			return;
		}

		for (int i = startIdx; i < src.length; i++) {
			choosed[choosed.length - toChoose] = src[i];
			makeCombination(toChoose - 1, choosed, i + 1);
		}
	}

}
