import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static PriorityQueue<Edge> stars;
	static double[][] star;
	static int[] p;
	static int[] r;
	static double result;
	static class Edge implements Comparable<Edge>{
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
		N = Integer.parseInt(br.readLine());
		stars = new PriorityQueue<>();
		star = new double[N+1][2];
		p = new int[N+1];
		r = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				double weight = Math.sqrt(Math.pow((star[i][0]- star[j][0]), 2)+Math.pow((star[i][1]- star[j][1]), 2));
				stars.offer(new Edge(i,j,weight));
			}
		}
		
		makeSet();
		result = 0;
		int cnt = 0;
		while(cnt!= N-1) {
			Edge edge = stars.poll();
			if(union(edge.s,edge.e)) {
				cnt++;
				result+= edge.w;
			}
		}
		System.out.printf("%.2f",result);
		
	}
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false;
		if(r[x] < r[y]) {
			p[x] = y;
			r[y] += r[x];
		}else {
			p[y]= x;
			r[x]+= r[y];
		}
		return true;
	}
	static int find(int x) {
		if(p[x] == x) return x;
		return p[x] = find(p[x]);
	}
	static void makeSet() {
		for (int i = 0; i < N+1; i++) {
			p[i] = i;
			r[i] = i;
		}
	}

}