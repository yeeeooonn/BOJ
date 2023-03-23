import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int x,y;
	static int[][] map;
	static int[] dice;
	static int[] dr = {0,0,-1,1};//동,서,북,남 순
	static int[] dc = {1,-1,0,0};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dice = new int[6]; //1: 윗면, 3:바닥면
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int direction = Integer.parseInt(st.nextToken());
			move(x,y,direction);
		}
		System.out.println(sb.toString());
		

	}
	static void move(int r, int c, int direction) {
		int nr = r + dr[direction-1];
		int nc = c + dc[direction-1];
		if(!check(nr,nc)) return;
		if(direction == 4) { //남쪽 이동
			sb.append(dice[0]).append("\n");
			if(map[nr][nc] == 0) {
				map[nr][nc] = dice[2];
			}else {
				dice[2] = map[nr][nc];
				map[nr][nc] = 0;
			}

			//주사위 순서 맞춰줌
			int temp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[2];
			dice[2]= dice[1];
			dice[1] = temp;
		}
		if(direction == 3) { //북쪽 이동
			sb.append(dice[2]).append("\n");
			if(map[nr][nc] == 0) {
				map[nr][nc] = dice[0];
			}else {
				dice[0] = map[nr][nc];
				map[nr][nc] = 0;
			}

			//주사위 순서 맞춰줌
			int temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[2];
			dice[2]= dice[3];
			dice[3] = temp;
		}
		if(direction == 2) { //서쪽 이동
			sb.append(dice[5]).append("\n");
			if(map[nr][nc] == 0) {
				map[nr][nc] = dice[4];
			}else {
				dice[4] = map[nr][nc];
				map[nr][nc] = 0;
			}

			//주사위 순서 맞춰줌
			int temp = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[5];
			dice[5]= dice[3];
			dice[3] = temp;
		}
		if(direction == 1) { //동쪽 이동
			sb.append(dice[4]).append("\n");
			if(map[nr][nc] == 0) {
				map[nr][nc] = dice[5];
			}else {
				dice[5] = map[nr][nc];
				map[nr][nc] = 0;
			}

			//주사위 순서 맞춰줌
			int temp = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[5];
			dice[5]= dice[1];
			dice[1] = temp;
		}
		x = nr;
		y = nc;
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<M;
	}

}