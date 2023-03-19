import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] p;
	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		double w;
		public Edge(int s, int e, double w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<int[]> list = new ArrayList<>();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new int[] {x,y});
		}
		for (int i = 1; i <= N; i++) {
			for (int j = i+1; j <= N; j++) {
				int start[] = list.get(i-1);
				int end[] = list.get(j-1);
				pq.offer(new Edge(i,j,Math.sqrt(Math.pow((start[0]-end[0]), 2)+ Math.pow((start[1]-end[1]), 2))));
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(start,end,0));
		}
		
		p = new int[N+1];
		double min = 0;
		int cnt = 0;
		makeSet();
		
		while(cnt != N-1) {
			Edge edge = pq.poll();
			if(union(edge.s,edge.e)) {
				cnt++;
				min+=edge.w;
			}
		}
		System.out.printf("%.2f",min);

	}
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false;
		p[y] = x;
		return true;
	}
	static int find(int x) {
		if(x == p[x]) return x;
		return p[x] = find(p[x]);
	}
	static void makeSet() {
		for (int i = 1; i < N+1; i++) {
			p[i]= i;
		}
	}
}