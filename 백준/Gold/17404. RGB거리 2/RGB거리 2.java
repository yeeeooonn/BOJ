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
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//첫번째집 - R일때
		dp = new int[N][3];
		dp[0][0] = cost[0][0];
		//첫번째집 - R일때, 두번째집
		for (int i = 0; i < 3; i++) {
			dp[1][0] = Integer.MAX_VALUE;
			dp[1][1] = dp[0][0] + cost[1][1];
			dp[1][2] = dp[0][0] + cost[1][2];
		}
		color();
		int minR = Math.min(dp[N-1][1], dp[N-1][2]);
		
		//첫번째집 - G일때
		dp = new int[N][3];
		dp[0][1] = cost[0][1];
		//첫번째집 - G일때, 두번째집
		for (int i = 0; i < 3; i++) {
			dp[1][0] = dp[0][1] + cost[1][0];
			dp[1][1] = Integer.MAX_VALUE;
			dp[1][2] = dp[0][1] + cost[1][2];
		}
		color();
		int minG = Math.min(dp[N-1][0], dp[N-1][2]);
		
		//첫번째집 - B일때
		dp = new int[N][3];
		dp[0][2] = cost[0][2];
		//첫번째집 - B일때, 두번째집
		for (int i = 0; i < 3; i++) {
			dp[1][0] = dp[0][2] + cost[1][0];
			dp[1][1] = dp[0][2] + cost[1][1];
			dp[1][2] = Integer.MAX_VALUE;
		}
		color();
		int minB = Math.min(dp[N-1][0], dp[N-1][1]);
		
		
		int min = Math.min(minR, minG);
		System.out.println(Math.min(min, minB));

	}
	static void color() {
		for (int i = 2; i < N; i++) {
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
		
	}

}