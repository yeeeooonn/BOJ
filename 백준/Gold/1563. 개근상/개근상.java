import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int MOD = 1_000_000;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][2][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }


        System.out.println(find(0, 0, 0) % MOD);

    }
    static int find(int day, int late, int absent) {
        if(late == 2 || absent == 3) {
            return 0;

        }
        if(day == N) {
            return 1;
        }

        if(dp[day][late][absent] == -1) {
            int count = find(day+1, late, 0)%MOD + find(day+1, late+1, 0)%MOD + find(day+1, late, absent+1)%MOD;
            count %= MOD;
            dp[day][late][absent] = count;
            return count;
        }else {
            return dp[day][late][absent];
        }

    }
}