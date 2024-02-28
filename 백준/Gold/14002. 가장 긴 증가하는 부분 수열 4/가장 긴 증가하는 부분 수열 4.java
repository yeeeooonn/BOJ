import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    static int[] answer;
    static int[] dp; //i 번째에서 내가 최대 몇번째 증가하는 수 인지
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());

            for (int j = i-1; j >= 0 ; j--) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i] , dp[j]+1);
                    result = Math.max(result, dp[i]);
                }
            }

        }
        System.out.println(result+1);

        answer = new int[result+1]; //정답 저장할 배열
        for (int i = N-1; i >= 0 ; i--) {
            if(dp[i] == result) {
                answer[result] = nums[i];
                result--;
            }
        }

        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);

        
    }
}