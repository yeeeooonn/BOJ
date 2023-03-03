//알고스팟
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M; //행,열
	static int[][] map;
	static int[][] distance;
	static int[] dr = {-1,0,1,0}; //위 오 아 왼
	static int[] dc = {0,1,0,-1};
	static class Edge{
		int r;
		int c;
		int w;
		public Edge(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		distance = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				distance[i][j] = Integer.MAX_VALUE/1000;
			}
		}
		
		//시작
		distance[0][0] = map[0][0];
		Queue<Edge> q = new LinkedList<>();
		q.offer(new Edge(0,0,distance[0][0]));
		while(!q.isEmpty()) {
			Edge edge = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = edge.r+dr[d];
				int nc = edge.c+dc[d];
				if(!check(nr,nc)) continue;
				if(distance[nr][nc] > distance[edge.r][edge.c]+map[nr][nc]) {
					distance[nr][nc] = distance[edge.r][edge.c]+map[nr][nc];
					q.offer(new Edge(nr,nc,distance[nr][nc]));
				}
			}
		}
		System.out.println(distance[N-1][M-1]);
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<M;
	}

}