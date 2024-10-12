import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] b;
    static boolean[][] dp; //dp[i][j] : i,j 개씩 구슬이 남았을 때 내가 이길 수 있는지
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        b = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b);

        dp = new boolean[501][501];

        for (int i = 0; i <= 500 ; i++) {
            for (int j = 0; j <= 500 ; j++) {
                if(i < b[0] && j < b[0]) {
                    //두 주머니에서 꺼낼 수 없는 경우
                    dp[i][j] = false;
                }

                //i에서 구슬 선택
                for (int k = 0; k < 3; k++) {
                    if(i - b[k] < 0) {
                        break;
                    }
                    if(!dp[i - b[k]][j]) {
                        dp[i][j] = true;
                    }
                }

                //i에서 구슬선택했는데 지는 경우 -> j에서 구슬선택
                if(!dp[i][j]) {
                    for (int k = 0; k < 3; k++) {
                        if (j - b[k] < 0) {
                            break;
                        }
                        if (!dp[i][j - b[k]]) {
                            dp[i][j] = true;
                        }
                    }
                }


            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(dp[a][b]) {
                sb.append("A").append("\n");
            }else {
                sb.append("B").append("\n");
            }
        }
        System.out.print(sb);


    }
}