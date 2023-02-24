import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V,E;
	static PriorityQueue<Edge> points;
	static long min;
	static int[] p;
	static int[] r; //랭크
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
		public int compareTo(Edge o) {//작은거 -> 큰거 순
			return Integer.compare(this.w, o.w);
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		points = new PriorityQueue<>();
		p = new int[V+1];
		r = new int[V+1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			points.offer(new Edge(s,e,w));
		}
		
		makeSet();
		min = 0;
		int cnt = 0;
		while(cnt != V-1) {
			Edge edge = points.poll();
			if(union(edge.s,edge.e)) {
				cnt++;
				min+= edge.w;
			}
		}
		System.out.println(min);
	}
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false;
		if(r[x] < r[y]) {
			p[x] = y;
			r[y]+= r[x];
		}else {
			p[y]=x;
			r[x]+=r[y];
		}
		
		return true;
	}
	static int find(int x) {
		if(x == p[x]) return x;
		return p[x] = find(p[x]);
	}
	static void makeSet() {
		for (int i = 0; i < V+1; i++) {
			p[i] = i;
			r[i] = i;
		}
	}
}