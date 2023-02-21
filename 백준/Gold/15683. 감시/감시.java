import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M; //행,열
	static int[][] map;
	static int[][] mapCopy;
	static int count; //CCTV 수
	static int[] cameraD; //카메라 방향 선택(0:오,1:아,2:왼,3:위)
	static List<int[]> cameraI; //카메라 위치, 카메라 종류 선택(1,2,3,4,5)
	static int result = Integer.MAX_VALUE; //결과 값(최소 사각지대 개수)
	static int direction;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mapCopy = new int[N][M];
		cameraI = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0 && map[i][j]!=6) {//CCTV 수
					cameraI.add(new int[] {i,j,map[i][j]});
				} 
			}
		}
		count = cameraI.size();
		cameraD = new int[count];

		perm(0);
		
		System.out.println(result);
	}
	static void perm(int cnt) {
		if(cnt == count) {
			//map -> mapCopy 복사
			for (int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, mapCopy[i], 0, map[0].length);
			}
			//채우기
			for (int i = 0; i < count; i++) {
				int a[] = cameraI.get(i); 
				direction = cameraD[i];
				dfs(a[0],a[1],a[2]);
			}
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(mapCopy[i][j] == 0) answer++;
				}
			}
			result = Math.min(result, answer);
			return;
		}
		for (int i = 0; i < 4; i++) {
			cameraD[cnt] = i;
			perm(cnt+1);
			cameraD[cnt] = 0;
		}
	}
	static void dfs(int r, int c, int info) {
		if(info==1)
			move1(r, c);
		if(info==2)
			move2(r, c);
		if(info==3)
			move3(r, c);
		if(info==4)
			move4(r, c);
		if(info==5)
			move5(r, c);
	}
	static void move5(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			while(check(nr,nc) && mapCopy[nr][nc] !=6) { //범위 벗어날때까지 & 벽 만날때 까지
				nr = nr + dr[d];
				nc = nc + dc[d];
				if(!check(nr,nc)) break;
				if(mapCopy[nr][nc] == 0) //0일 때만 -1넣기(CCTV 패스)
					mapCopy[nr][nc] = -1;
			}
		}	
	}
	static void move4(int r, int c) {
		int pass = Math.floorMod(direction + 2, 4);
		for (int d = 0; d < 4; d++) {
			if(d ==pass) continue;
			int nr = r;
			int nc = c;
			while(check(nr,nc) && mapCopy[nr][nc] !=6) { //범위 벗어날때까지 & 벽 만날때 까지
				nr = nr + dr[d];
				nc = nc + dc[d];
				if(!check(nr,nc)) break;
				if(mapCopy[nr][nc] == 0) //0일 때만 -1넣기(CCTV 패스)
					mapCopy[nr][nc] = -1;
			}
		}
	}
	static void move3(int r, int c) {
		int pass1 = Math.floorMod(direction+1, 4);
		int pass2 = Math.floorMod(direction+2, 4);
		for (int d = 0; d < 4; d++) {
			if(d ==pass1 || d == pass2) continue;
			int nr = r;
			int nc = c;
			while(check(nr,nc) && mapCopy[nr][nc] !=6) { //범위 벗어날때까지 & 벽 만날때 까지
				nr = nr + dr[d];
				nc = nc + dc[d];
				if(!check(nr,nc)) break;
				if(mapCopy[nr][nc] == 0) //0일 때만 -1넣기(CCTV 패스)
					mapCopy[nr][nc] = -1;
			}
		}
	}
	static void move2(int r, int c) {
		int pass1 = direction;
		int pass2 = direction;
		if(direction < 2) {
			pass2 = direction+2;
		}else {
			pass2 = direction-2;
		}
		
		for (int d = 0; d < 4; d++) {
			if(d ==pass1 || d == pass2) continue;
			int nr = r;
			int nc = c;
			while(check(nr,nc) && mapCopy[nr][nc] !=6) { //범위 벗어날때까지 & 벽 만날때 까지
				nr = nr + dr[d];
				nc = nc + dc[d];
				if(!check(nr,nc)) break;
				if(mapCopy[nr][nc] == 0) //0일 때만 -1넣기(CCTV 패스)
					mapCopy[nr][nc] = -1;
			}
		}
	}
	static void move1(int r, int c) {
		//direction 일때만 진행
		int nr = r;
		int nc = c;
		while(check(nr,nc) && mapCopy[nr][nc] !=6) { //범위 벗어날때까지 & 벽 만날때 까지
			nr = nr + dr[direction];
			nc = nc + dc[direction];
			if(!check(nr,nc)) break;
			if(mapCopy[nr][nc] == 0) //0일 때만 -1넣기(CCTV 패스)
				mapCopy[nr][nc] = -1;
		}
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<M;
	}
}