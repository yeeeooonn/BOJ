import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static int mapcopy[][];
	static int[] p; //pick
	static int len;
	static int result; //안전영역 개수
	static List<int[]> virus;
	static List<int[]> blank;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mapcopy = new int[N][M];
		virus = new ArrayList<>();
		blank = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new int[] {i,j});
				}
				if(map[i][j] == 0) {
					blank.add(new int[] {i,j});
				}
			}
		}

		p = new int[3];
		
		combi(0,0);
		System.out.println(result);
	}
	static void combi(int cnt, int start) {
		if(cnt == 3) {
			bfs(p);
			safe();
			return;
		}
		for (int i = start; i < blank.size(); i++) {
			p[cnt] = i;
			combi(cnt+1,i+1);
			p[cnt] = 0;
		}
		
	}
	
	static void safe() {
		int count = 0; //안전영역 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(mapcopy[i][j] ==0) {
					count++;
				}
			}
		}
		result = Math.max(result, count);
	}
	static void bfs(int[] p) {
		for (int i = 0; i < N; i++) { //map -> mapcopy 복사
			System.arraycopy(map[i], 0, mapcopy[i], 0, map[0].length);
		}
		
		for (int i = 0; i < 3; i++) { //벽으로 만들어주기
			int[]wall = blank.get(p[i]);
			mapcopy[wall[0]][wall[1]] = 1;
		}
		
		
		for (int i = 0; i < virus.size(); i++) {
			int[] curV = virus.get(i);
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {curV[0],curV[1]});
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0]+dr[d];
					int nc = cur[1]+dc[d];
					if(!(check(nr,nc))) continue;
					if(mapcopy[nr][nc]==0) {
						mapcopy[nr][nc]=2; //방문표시
						q.offer(new int[] {nr,nc});
					}
				}
			}
			
		}
		
	}
	static boolean check(int nr, int nc) {
		return nr<N && nc<M && nr>=0 && nc>=0;
	}

}