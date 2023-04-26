import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][] p1;
	static boolean[][] p2;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static class E {
		int x;
		int y;
		char c;
		public E(int x, int y, char c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		p1 = new boolean[N][N];
		p2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		//일반사람 -> R,G,B / 적록색약 -> RG,B
		
		int result1 = 0;
		int result2 = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!p1[i][j]) {
					result1++;
					bfs1(i,j,map[i][j]);
				}
				if(!p2[i][j]) {
					result2++;
					bfs2(i,j,map[i][j]);
				}
			}
		}
		
		System.out.println(result1+" "+result2);
		

	}
	private static void bfs2(int i, int j, char c) {
		Queue<E> q = new LinkedList<>();
		q.offer(new E(i,j,c));
		p2[i][j] = true;
		
		while(!q.isEmpty()) {
			E cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(!check(nr,nc)) continue;
				
				if(!p2[nr][nc] && cur.c == 'B' && map[nr][nc] == cur.c) {
					p2[nr][nc] = true;
					q.offer(new E(nr,nc,c));
				}
				if(!p2[nr][nc] && cur.c != 'B' && map[nr][nc] != 'B') {
					p2[nr][nc] = true;
					q.offer(new E(nr,nc,c));
				}
			}
		}
		
		
	}
	static void bfs1(int i, int j, char c) {
		Queue<E> q = new LinkedList<>();
		q.offer(new E(i,j,c));
		p1[i][j] = true;
		
		while(!q.isEmpty()) {
			E cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(!check(nr,nc)) continue;
				
				if(!p1[nr][nc] && map[nr][nc] == cur.c) {
					p1[nr][nc] = true;
					q.offer(new E(nr,nc,c));
				}
			}
		}
		
	}
	static boolean check(int nr, int nc) {
		return nr<N && nc<N & nr>=0 && nc>=0;
	}

}