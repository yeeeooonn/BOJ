import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int x1,x2,y1,y2;
	static int map[][];
	static boolean visited[][][];
	static int[] dx = {-1,1,0,0}; //위아래 , 왼오
	static int[] dy = {0,0,-1,1};
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {			
			result = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken())+100;
			y1 = Integer.parseInt(st.nextToken())+100;
			x2 = Integer.parseInt(st.nextToken())+100;
			y2 = Integer.parseInt(st.nextToken())+100;
			
			
			visited = new boolean[201][201][2];

			bfs();

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {x1,y1,0,0}); //x좌표, y좌표, 시작방향(0: 위아래, 1: 왼오), 이전방향(0: 위아래, 1: 왼오),카운트
		q.offer(new int[] {x1,y1,1,0});
		visited[x1][y1][0] = true;
		visited[x1][y1][1] = true;
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			if(cur[0] == x2 && cur[1] == y2) {
				result = cur[3];
				return;
			}
			if(cur[2] == 0) { // 이전 방향이 위아래일 때
				for (int d = 2; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if(!check(nx,ny)) continue;
					if(visited[nx][ny][1]) continue;
					q.offer(new int[] {nx,ny,1,cur[3]+1});
					visited[nx][ny][1] = true;
				}
			}
			if(cur[2] == 1) { // 이전 방향이 왼오일때
				for (int d = 0; d < 2; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if(!check(nx,ny)) continue;
					if(visited[nx][ny][0]) continue;
					q.offer(new int[] {nx,ny,0,cur[3]+1});
					visited[nx][ny][0] = true;
				}
			}
		}
		
	}
	static boolean check(int nx, int ny) {
		return nx<201 && ny< 201 && nx>=0 && ny>=0;
	}
}