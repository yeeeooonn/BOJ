import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()) + 1;
        long dp[][] = new long[N+2][2];
        /*
	        dp[i][0] => i번째 땅에서 2가 하나도 없는 경우
	        dp[i][1] => i번째 땅에서 2가 하나라도 나온 경우
	    */

        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[2][0] = 1;
        dp[2][1] = 0;
        dp[3][0] = 2;
        dp[3][1] = 1;


        for(int i=4;i<=N;i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0] + dp[i-3][0];
            dp[i][0]%=MOD;
            dp[i][1] = dp[i-1][1] + dp[i-2][0] + dp[i-2][1]*2 + dp[i-3][0]*2 + dp[i-3][1]*3;
            dp[i][1]%=MOD;
        }
        System.out.println(dp[N][1]);

    }

}