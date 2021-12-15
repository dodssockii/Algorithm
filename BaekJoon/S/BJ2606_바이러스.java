import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ2606_바이러스 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int com, count; // computer 개수, 쌍의 개수
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		com = Integer.parseInt(br.readLine().trim());
		count = Integer.parseInt(br.readLine().trim());
		
		map = new int[com+1][com+1];
		visited = new boolean[com+1];
		
		for(int i=0; i<count; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int x =Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		System.out.println(bfs(1));
		
	}
	
	public static int bfs(int k) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(k);
		while(!queue.isEmpty()) {
			int x = queue.poll();
			visited[x] = true;
			for(int i=1; i<=com; i++) {
				if(map[x][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}

}
