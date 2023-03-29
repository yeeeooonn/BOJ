import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int direction; // 방향(0:가로,1:대각선,2:세로)
	static int[] dr = {0,1,1}; //가로, 대각선, 세로 순
	static int[] dc = {1,1,0};
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,1,0); //행,열,파이프 방향
		System.out.println(result);
	}
	static void dfs(int r, int c, int dir) {
		if(c >= N || r >= N || map[r][c] == 1 ) {
			return;
		}
		
		if(dir == 0) { //가로 방향 일 때 이동
			dfs(r,c+1,0);
			dfs(r+1,c+1,1);
		}
		if(dir == 1) { //대각선 방향일 때 이동
			if(map[r-1][c] == 1 || map[r][c-1] ==1) {
				return;
			}
			dfs(r,c+1,0);
			dfs(r+1,c+1,1);
			dfs(r+1,c,2);
			
		}
		if(dir == 2) { //세로 방향 일 때 이동
			dfs(r+1,c+1,1);
			dfs(r+1,c,2);
		}
		
		if(c == N-1 && r == N-1) {
			result++;
			return;
		}
		
	}

}