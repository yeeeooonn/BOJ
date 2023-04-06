import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int [][] W;
	static int [][] dp;
	static int min;
	static int INF=Integer.MAX_VALUE/100;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		W=new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <N; j++) {
				W[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp=new int[1<<N][N];
		for (int i =0; i < 1<<N ; i++) {
			Arrays.fill(dp[i], -1);
		}
		min=tsp(1,0);
		System.out.println(min);
		
	}
	private static int tsp(int visited,int city) {
		// 모두 방문했니 그러면 마지막 도시와 집과의 거리는?
		if(visited==((1<<N)-1)){ 
			//만약 연결이 안되어 있다면 
			if(W[city][0]==0) return INF;
			return W[city][0];// 마지막 도시와 집까지 거리
		}
		// 도시 방문순서를 고려포함
		// 방문도시 순서에(이 도시 방문하려고 함) 같은 순서가 있어
		if(dp[visited][city]!=-1){
			return dp[visited][city];
		}
		// 방문 표시
		dp[visited][city]=INF;
		for (int i = 0; i < N; i++) {
			// 중복방문x
			if((visited &(1<<i))!=0)continue;
			// 도시가 연결안됨
			if(W[city][i]==0)continue;
			
			int res=tsp(visited |(1<<i),i)+W[city][i];
			dp[visited][city]=Math.min(res, dp[visited][city]);
		}
		return dp[visited][city];
	}
}