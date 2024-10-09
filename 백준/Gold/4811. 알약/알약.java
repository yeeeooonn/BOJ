import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        int N = 30;

        long[][] dp = new long[N+1][N+1]; //dp[3][2] => w 3개, h 2개 쓴 시점 경우의 수
        dp[1][0] = 1;

        for (int w = 0; w <= N; w++) {
            for (int h = 0; h <= N; h++) {
                if(w < N) {
                    dp[w+1][h] += dp[w][h];
                }
                if(h < w) {
                    dp[w][h+1] += dp[w][h];
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) break;
            sb.append(dp[input][input]).append("\n");
        }
        System.out.print(sb);

    }
}