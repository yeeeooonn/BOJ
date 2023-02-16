import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H,W; //행,열
	static int[][] map;
	static int[][] mapCopy;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int time;
	static int cheese;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		mapCopy = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//다 녹을 때까지
		while(!isAllmelt()) {
			time++;
			for (int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, mapCopy[i], 0, map[0].length);
			}
			//공기 2로 채우기
			bfs(0,0);
			//치즈가 있는 부분 주변탐색하고 3으로바꾸기
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(mapCopy[i][j] == 1)
						melt(i,j);
				}
			}
		}
		System.out.println(time);
	}
	static boolean isAllmelt() {
		cheese = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]!=0) {
					cheese++;
				}
			}
		}
		if(cheese == 0) return true;
		return false;
	}
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		mapCopy[r][c] = 2;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(!check(nr,nc)) continue;
				if(mapCopy[nr][nc] == 0) {
					mapCopy[nr][nc] =2;
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}
	static void melt(int r, int c) {
		int count = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!check(nr,nc)) continue;
			if(mapCopy[nr][nc] == 2)
				count++;
		}
		if(count>=2) {
			//3으로 바뀐 부분 맵에서 0으로 바꿔주기
			mapCopy[r][c] =3;
			map[r][c] = 0;
		}
			
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<H && nc<W;
	}

}