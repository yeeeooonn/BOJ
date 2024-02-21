import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N*3];
        dp = new int[N*3][N*3];
        String str = br.readLine();
        for (int i = 0; i < 3*N; i++) {
            char c = str.charAt(i);
            if(c == 'L') {
                arr[i] = 1;
            }else if(c == 'D') {
                arr[i] = 2;
            }
        }
        for (int i = 0; i < 3*N; i++) {
            for (int j = 0; j < 3*N; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(check(0, 3*N-1, 0)); //시작점, 끝점, 먹어야할것

    }
    static int check(int start, int end, int need) {
        if(start > end) return 0;
        int answer = dp[start][end];
        if(answer != -1) return answer;

        answer = 0;
        if(arr[start]%3 == need%3) {
            //먹어야 할 약 이면
            answer = Math.max(answer, check(start+1, end, need+1)+1);
        }
        if(arr[end]%3 == need%3) {
            answer = Math.max(answer, check(start, end-1, need+1)+1);

        }
        dp[start][end] = answer; //기록
        return answer;
    }
}