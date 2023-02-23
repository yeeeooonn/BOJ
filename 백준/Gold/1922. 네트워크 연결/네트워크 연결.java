import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int min;
	static int[] p;
	static int[] rank;
	static PriorityQueue<Edge> points;
	static class Edge implements Comparable<Edge> {
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
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		points = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			points.offer(new Edge(s,e,w));
		}
		makeSet();
		min = 0;
		int cnt = 0;
		while(cnt!= N-1) {
			Edge edge = points.poll(); //가장 작은 거 뽑음
			if(union(edge.s, edge.e)) { //연결했으면 더함
				cnt++;
				min += edge.w;
			}
		}
		System.out.println(min);
		
	}
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false; //사이클 있다
		if(rank[x]< rank[y]) {
			p[x] = y;
			rank[y] += rank[x];
		}else {
			p[y] = x;
			rank[x]+= rank[y];
		}
		return true;
	}
	static int find(int x) {
		if(x == p[x]) return x;
		return p[x] = find(p[x]);
	}
	static void makeSet() {
		p = new int[N+1];
		rank = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			p[i] = i;
			rank[i] = 1;
		}
		
	}

}