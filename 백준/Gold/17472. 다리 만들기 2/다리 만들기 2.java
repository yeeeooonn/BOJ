import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int groupCnt;
	static int result;
	static int[][] map;
	static int[][] krus;
	static int[] p;
	static int[] r;
	static int[] dr = {0,-1,0,1};
	static int[] dc = {-1,0,1,0};
	static PriorityQueue<Edge> pq ;
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int w;
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//ff
		groupCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					groupCnt++;
					dfs(i,j,groupCnt+1);
				}
			}
		}
		
		krus = new int[groupCnt][groupCnt];
		for (int i = 0; i < groupCnt; i++) {
			Arrays.fill(krus[i], Integer.MAX_VALUE);
		}
		
		
		//Group 별 거리 pg에 넣기
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int g = 2; g < groupCnt+2; g++) {
					if(map[i][j] == g) {
						findOther(i,j,g);
					}
				}
			}
		}
		for (int i = 0; i < groupCnt; i++) {
			for (int j = i+1; j < groupCnt; j++) {
				if(krus[i][j]!= Integer.MAX_VALUE) {
					pq.offer(new Edge(i,j,krus[i][j]));
				}
			}
		}
		
		//MST
		p = new int[groupCnt+2];
		r = new int[groupCnt+2];
		MakeSet(); //초기화
		result = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(!isConnect(edge.s, edge.e)) {
				cnt++;
				union(edge.s,edge.e);
				result += edge.w;
			}
		}
		if(cnt == groupCnt-1) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}

		
	}
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px==py) return;
		if(r[px]>= r[py]) {
			p[py] = px;
			r[px] += r[py];
		}else {
			p[px] = py;
			r[py] += r[px];
		}
		
	}
	static boolean isConnect(int x, int y) {
		return find(x) == find(y);
	}
	static int find(int x) {
		if(x == p[x]) {
			return p[x];
		}else {
			return p[x] =find(p[x]);
		}
	}
	static void findOther(int r, int c, int k) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int g = k+1; g < groupCnt+2; g++) {
					if(map[i][j] == g) {
						int dis = distance(r,c,i,j);
						krus[k-2][g-2] = Math.min(krus[k-2][g-2], dis);
						krus[g-2][k-2] = krus[k-2][g-2];
					}
				}
			}
		}
		
	}
	static int distance(int r1, int c1, int r2, int c2) {
		int tmin = Integer.MAX_VALUE;
		for (int d = 0; d < 4; d++) {
			int dis = bfs(r1,c1,r2,c2,d);
			if(dis<2) { //다리길이가 2 이상이여야 함
				dis = Integer.MAX_VALUE;
			}
			tmin = Math.min(dis, tmin);
		}
		return tmin;
	}
	static int bfs(int r1, int c1, int r2, int c2, int d) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r1,c1,0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int nr = cur[0] + dr[d];
			int nc = cur[1] + dc[d];
			if(!check(nr,nc)) continue;
			if(nr == r2 && nc == c2) {
				return cur[2];
			}
			if(map[nr][nc] == 0) {
				q.offer(new int[] {nr,nc,cur[2]+1});
			}
		}
		return Integer.MAX_VALUE;
	}
	static void MakeSet() {
		for (int i = 0; i < groupCnt+2; i++) {
			p[i] = i;
			r[i] =1;
		}
		
	}
	static void dfs(int r, int c, int g) {
		map[r][c] = g;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!check(nr,nc)) continue;
			if(map[nr][nc] == 1) {
				dfs(nr,nc,g);
			}
		}
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<M;
	}

}