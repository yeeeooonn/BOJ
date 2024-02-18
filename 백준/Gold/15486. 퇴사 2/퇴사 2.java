import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] counsel = new int[N+1][2]; //0:시간, 1:금액
        int[] dp = new int[N+1]; //index 시간에 최대 금액
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            counsel[i][0] = Integer.parseInt(st.nextToken());
            counsel[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i-1];
            for (int j = i; j >= Math.max(0, i - 50); j--) {
                if(i == j + counsel[j][0] -1) { //i 시점에 끝나는 상담인 경우
                    dp[i] = Math.max(dp[i], counsel[j][1]+ dp[j-1]);
                }
            }
        }

        System.out.println(dp[N]);

    }
}