import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static BigInteger dp[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new BigInteger[1001][1001];
		set(N,M);
		
		System.out.println(dp[N][M]);
	}
	static void set(int n, int m) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					dp[i][j] = new BigInteger("1");
				}else {
					dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
				}
			}
		}
	}

}