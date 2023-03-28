import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] dp;
	static int MOD = 10007;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		dp[0] = dp[1] = 1;
		for (int i = 2; i < N+1; i++) {
			dp[i] = (dp[i-2]*2 + dp[i-1])%MOD;
		}
		System.out.println(dp[N]);
	}

}