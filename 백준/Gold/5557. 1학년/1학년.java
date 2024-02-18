import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int num;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[][] dp = new long[N][21];
        num = Integer.parseInt(st.nextToken());
        dp[0][num] = 1;

        for (int i = 1; i < N-1; i++) {
            num = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= 20; j++) {
                if(dp[i-1][j] > 0) { //이전에 숫자가 있었다면
                    if(0 <= j-num) {
                        dp[i][j-num] += dp[i-1][j];
                    }
                    if(j+num <= 20) {
                        dp[i][j+num] += dp[i-1][j];
                    }
                }
            }

        }
        num = Integer.parseInt(st.nextToken());
        System.out.println(dp[N-2][num]);

    }
}