
public class BJ4673_셀프넘버 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		boolean[] self = new boolean[10001];

		for (int i = 1; i < 10001; i++) {
			int x = d(i);

			if (x < 10001) {
				self[x] = true;
			}
		}

		for (int j = 1; j < 10001; j++) {
			if (!self[j]) {
				sb.append(j).append('\n');
			}
		}
		System.out.println(sb);
	}

	static public int d(int num) {
		int sum = num;
		while (num != 0) {
			sum = sum + (num % 10);
			num = num / 10;
		}
		return sum;
	}

}
