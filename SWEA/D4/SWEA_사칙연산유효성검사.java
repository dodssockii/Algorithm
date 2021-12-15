import java.io.IOException;
import java.util.Scanner;

public class SWEA_사칙연산유효성검사 {

	static StringBuilder sb = new StringBuilder();
	
	static char[] tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int answer = 1;
			int cur = 0;
			int N = sc.nextInt();
			tree = new char[N+1];
			sc.nextLine();
			for(int i=0; i<N; i++) {
				String[] s = sc.nextLine().split(" ");
				cur = Integer.parseInt(s[0]);
				tree[cur] = s[1].charAt(0);
				
				if(tree[cur]!='+' && tree[cur]!='-'&& tree[cur]!='*'&& tree[cur]!='/') {
					if(cur%2==0 && cur/2>0) {
						if(tree[cur/2]!='+'&& tree[cur/2]!='-'&& tree[cur/2]!='*'&& tree[cur/2]!='/') {
							answer = 0;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", t, answer);
		}
	}

}
