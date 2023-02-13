import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int [][] ground;
	static boolean [][] check;
	static int count;
	static int result = 1;
	static int[] dr = {-1,0,1,0}; //상우하좌
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ground = new int[N][N];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				if(ground[i][j] > max) max = ground[i][j];
				if(ground[i][j] < min) min = ground[i][j];
			}
		}
		
		for (int i = min; i < max; i++) {
			count = 0;
			check = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(ground[j][k] > i && check[j][k]== false) {
						count++;
						check[j][k] = true;
						bfs(j,k,i);
					}
				}
			}
			result = Math.max(count, result);
		}
		System.out.println(result);

	}
	static void bfs(int r, int c, int rain) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(!check(nr,nc)) continue;
				if(ground[nr][nc] > rain && check[nr][nc]==false) {
					check[nr][nc] = true;
					q.offer(new int[] {nr,nc,rain});
				}
			}
		}
		
		
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}

}