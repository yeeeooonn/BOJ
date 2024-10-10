import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] t= new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }


        int[][][][] dp = new int[N+1][10][10][10];
        //초기값
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        dp[i][j][k][l] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        dp[0][0][0][0] = 0;

        for (int n = 1; n <= N; n++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 10; k++) {
                        if (dp[n - 1][k][i][j] != Integer.MAX_VALUE) {
                            int cost = Math.min(Math.abs(k - t[n]), 10 - Math.abs(k - t[n]));
                            dp[n][t[n]][i][j] = Math.min(dp[n][t[n]][i][j], dp[n - 1][k][i][j] + cost);
                            dp[n][i][t[n]][j] = Math.min(dp[n][i][t[n]][j], dp[n - 1][i][k][j] + cost);
                            dp[n][i][j][t[n]] = Math.min(dp[n][i][j][t[n]], dp[n - 1][i][j][k] + cost);
                        }
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                answer = Math.min(answer, dp[N][t[N]][i][j]);
                answer = Math.min(answer, dp[N][i][t[N]][j]);
                answer = Math.min(answer, dp[N][i][j][t[N]]);
            }
        }
        System.out.println(answer);


    }
}