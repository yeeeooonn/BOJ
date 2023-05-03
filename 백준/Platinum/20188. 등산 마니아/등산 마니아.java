import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer>[] list;
	static int[] dp;
	static long result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//리스트, dp배열 초기화
		list = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		dp = new int[N+1];
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dp(1);
		
		System.out.println(result);
		

	}
	private static int dp(int cur) {
		dp[cur] = 1;
		for (int next : list[cur]) {
			if(dp[next] == 0) {
				dp[cur]+= dp(next);
			}
		}
		if(cur!=1) {
			result += combi(N) - combi(N-dp[cur]);
		}
		
		return dp[cur];
		
	}
	private static long combi(int n) {
		return (long)n * (long)(n-1) / 2;
	}

}