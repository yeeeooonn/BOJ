import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] cost;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//초깃값
		for (int i = 0; i < 3; i++) {
			dp[0][i] = cost[0][i];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if(j == 0) {
					dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][j];
				}
				if(j == 1) {
					dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][j];
				}
				if(j == 2) {
					dp[i][j] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][j];
				}				
			}
		}
        
		int min = Math.min(dp[N-1][0], dp[N-1][1]);
		System.out.println(Math.min(min, dp[N-1][2]));
	}
}