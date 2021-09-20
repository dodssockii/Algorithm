
import java.util.ArrayList;

public class PowerSetDupPer_부분집합 {

	static char[] src = { 'a', 'b', 'c', 'd' };

	public static void main(String[] args) {
		// N(src)개에서 구성할 수 있는 부분집합
		powerSetDupPer(3, new boolean[3]);
	}

	private static void powerSetDupPer(int toChoose, boolean[] choosed) {
		if (toChoose == 0) {
			print(choosed);
			return;
		}

		choosed[toChoose - 1] = true;
		powerSetDupPer(toChoose - 1, choosed);
		choosed[toChoose - 1] = false;
		powerSetDupPer(toChoose - 1, choosed);
	}

	private static void print(boolean[] temp) {
		ArrayList<Character> list1 = new ArrayList<>();
		ArrayList<Character> list2 = new ArrayList<>();

		for (int i = 0; i < temp.length; i++) {
			if (temp[i]) {
				list1.add(src[i]);
			} else {
				list2.add(src[i]);
			}
		}
		System.out.printf("%s : %s%n", list1, list2);
	}

}
