import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N,M;
	static int[][] floyd;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			result = 0;
			floyd = new int[N+1][N+1];

			
			//입력
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				floyd[s][e] = 1;
			}

			
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if(floyd[i][k] != 0 && floyd[k][j] != 0) {
							floyd[i][j] = 1;						
						}
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				int answer = 0;
				for (int j = 1; j <= N; j++) {
					if(floyd[i][j] == 1) answer++;
					if(floyd[j][i] == 1) answer++;
				}
				if(answer == N-1) {
					result++;
				}
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());

	}

}