import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] com;
	static boolean[] visit;
	static int[][] road;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		com = new int[N+1];
		visit = new boolean[N+1];
		road = new int[N+1][N+1];
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			road[x][y] =1;
			road[y][x] =1;
		}
		bfs();
		System.out.println(count);
	}
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{1,0});
		visit[1] = true;
		while(!q.isEmpty()) {
			int a[] = q.poll();
			for (int d = 1; d < N+1; d++) {
				int nr = a[0];
				int nc = d;
				
				if(!check(nr,nc) || visit[nc]) continue;
				if(road[nr][nc] == 1) {
					count++;
					q.offer(new int[] {nc,0});
					visit[nc] = true;
				}
			}
		}
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N+1 && nc<N+1;
	}

}