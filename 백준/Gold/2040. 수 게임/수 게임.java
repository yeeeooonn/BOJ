import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    static int[] sum; //누적 합
    static int[] dp; //메모이제이션 : i 에서 (내 최소합) - (상대의 최소합)이 제일 작은 것
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int n = 0; n < 3; n++) {
            nums = new int[N+1];
            sum = new int[N+1];
            dp = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = N-1; i >= 0; i--) {
                sum[i] = nums[i] + sum[i+1];
            }

            Arrays.fill(dp, Integer.MIN_VALUE);
            
            int answer = find(N-1);
            if(answer < 0) {
                sb.append("A\n");
            }else if(answer > 0) {
                sb.append("B\n");
            }else {
                sb.append("D\n");
            }
        }
        System.out.println(sb);


    }
    static int find(int cur) {
        if(cur < 0) return 0;
        if(dp[cur] != Integer.MIN_VALUE) return dp[cur];

        int temp = Integer.MAX_VALUE;

        for (int i = cur; i >= 0 ; i--) {
            temp = Math.min(temp, sum(cur, i) - find(i-1));
        }
        dp[cur] = temp;
        return dp[cur];
    }
    static int sum(int s, int e) {
        return sum[e] - sum[s+1];
    }
}