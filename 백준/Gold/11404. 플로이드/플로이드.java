import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] dist;
	static int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N+1][N+1];
		//초기화 max값으로
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i != j) {
					dist[i][j] = MAX;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dist[s][e] = Math.min(dist[s][e], w);
		}
		
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(dist[i][k]!= MAX && dist[k][j]!= MAX) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
		}
		
		//출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(dist[i][j] == MAX) {
					sb.append("0 ");
				}else {
					sb.append(dist[i][j]).append(" ");					
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}