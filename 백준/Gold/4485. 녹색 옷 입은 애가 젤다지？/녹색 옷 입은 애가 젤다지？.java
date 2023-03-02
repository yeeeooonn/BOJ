import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//우선순위 큐 사용
public class Main {
	static int N ;
	static int count;
	static int result;
	static int[][] map;
	static int[][] distance; //비용 저장
	static int[] dr = {-1,0,1,0}; //위 오 아 왼
	static int[] dc = {0,1,0,-1};
	static class Edge implements Comparable<Edge>{
		int r;
		int c;
		int w;
		public Edge(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		while(N != 0) {
			count++;
			map = new int[N][N];
			distance = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//큰 값으로 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					distance[i][j] = Integer.MAX_VALUE/1000;
				}
			}
			//시작
			distance[0][0] = map[0][0];
			PriorityQueue<Edge> q = new PriorityQueue<>();
			q.offer(new Edge(0,0,map[0][0]));
			while(!q.isEmpty()) {
				Edge cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur.r+ dr[d];
					int nc = cur.c+ dc[d];
					if(!check(nr,nc)) continue;
					if(distance[nr][nc]> distance[cur.r][cur.c] + map[nr][nc]) {
						distance[nr][nc] = distance[cur.r][cur.c] + map[nr][nc];
						q.offer(new Edge(nr,nc,distance[nr][nc]));
					}
				}
			}
			result = distance[N-1][N-1];
			
			sb.append("Problem ").append(count).append(": ").append(result).append("\n");
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb.toString());

	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}

}