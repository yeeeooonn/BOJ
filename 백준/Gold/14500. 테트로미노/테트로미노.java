import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		max = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i,j,map[i][j],1); // 좌표, 합, depth
				visited[i][j] = false;
			}
		}
		
		System.out.println(max);

	}
	static void dfs(int row, int col, int sum, int depth) {
		
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			
			if(!check(nr,nc)) continue;
			if(!visited[nr][nc]) {
				
				if(depth == 2) { // ㅜ 모양 만들기 위해 진행
					visited[nr][nc] = true;
					dfs(row,col,sum+map[nr][nc],depth+1);
					visited[nr][nc] = false;
				}
				
				visited[nr][nc] = true;
				dfs(nr,nc,sum+map[nr][nc],depth+1);
				visited[nr][nc] = false;
			}
		}
		
	}
	static boolean check(int nr, int nc) {
		return nr<N && nc<M && nr>=0 && nc>=0;
	}

}