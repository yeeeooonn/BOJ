import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static int N; //돌 던진 횟수
	static int start;
	static char[][] map;
	static Stack<int[]>[] dp;
	static int[] dr= {1,0,0}; //아, 왼, 오
	static int[] dc= {0,-1,1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		dp = new Stack[C];
		for (int i = 0; i < C; i++) {
			dp[i] = new Stack<>();
		}
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			start = Integer.parseInt(br.readLine());
			
			while(!dp[start-1].isEmpty() && map[dp[start-1].peek()[0]][dp[start-1].peek()[1]] =='O') { //돌이 있다면 없는 곳 까지 pop으로 빼 줌
				dp[start-1].pop();
			}
			if(dp[start-1].isEmpty()) { //비어 있을 때 처음부터 시작
				dfs(0,start-1,start-1); 
			}
			if(!dp[start-1].isEmpty()) {
				dfs(dp[start-1].peek()[0],dp[start-1].peek()[1],start-1);
			}
		}
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}
	static void dfs(int r, int c, int s) { //행,열,초기돌던진값
		dp[s].push(new int[] {r,c}); //경로 저장
		//아래 빌 때
		int nr = r + dr[0];
		int nc = c + dc[0];
		if(check(nr,nc)) {
			if(map[nr][nc] =='X'|| r == R-1) {
				map[r][c] = 'O';
				return;
			}
			if(map[nr][nc] =='.') {
				dfs(nr,nc,s);
				return;
			}
		}
		//여기 오면 아래가 O일 때
		//왼쪽, 왼쪽 아래 빌 때
		nr = r + dr[1];
		nc = c + dc[1];
		if(check(nr,nc) && check(nr+1,nc)) { //순서대로 왼쪽, 왼쪽아래
			if(map[nr][nc] =='.' && map[nr+1][nc]=='.') {
				dfs(nr+1,nc,s);
				return;
			}
		}
		//오른쪽, 오른쪽 아래 빌 때
		nr = r + dr[2];
		nc = c + dc[2];
		if(check(nr,nc) && check(nr+1,nc)) { //순서대로 오른쪽, 오른쪽아래
			if(map[nr][nc] =='.' && map[nr+1][nc]=='.') {
				dfs(nr+1,nc,s);
				return;
			}
		}
		
		//아래 O이고, 왼 오 다 안빌 때
		map[r][c] = 'O';
		return;
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<R && nc<C;
	}

}