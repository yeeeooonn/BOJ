import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int V,E,K;
	static List<Edge>[] list;
	static int[] distance;
	static boolean[] checked;
	static int MM = Integer.MAX_VALUE/1000;
	static class Edge{
		int v;
		int w;
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		distance = new int[V+1];
		Arrays.fill(distance, MM); //큰 값으로 초기화
		for (int i = 0; i < V+1; i++) {
			list[i] = new ArrayList<>();
		}
		//입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Edge(e,w));
		}
		
		//시작
		checked = new boolean[V+1];
		distance[K] = 0;
		for (int i = 1; i < V; i++) {
			int w = -1;
			int minV = MM;
			for (int j = 1; j < V+1; j++) {
				if(!checked[j] && minV>distance[j]) {
					minV = distance[j];
					w = j;
				}
			}
			if(w == -1) break; //끊어짐
			checked[w] = true;
			for (Edge next : list[w]) {
				if(!checked[next.v] && distance[w]+next.w < distance[next.v]) {
					distance[next.v] = distance[w]+ next.w;
				}
			}
		}
		
		for (int i = 1; i < V+1; i++) {
			if(distance[i]!= MM) {
				sb.append(distance[i]).append("\n");
			}
			if(distance[i]== MM) {
				sb.append("INF\n");
			}
		}
		System.out.println(sb.toString());
	}
}