import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] sum = new int[N+1][M+1]; //0,0 ~ i,j 직사각형의 합

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int num = Integer.parseInt(st.nextToken());
                sum[i][j] = num + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1]; //누적합
            }
        }
        
        int answer = Integer.MIN_VALUE;


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                //하나씩 본다.

                for (int k = 0; k < i; k++) {
                    for (int l = 0; l < j; l++) {
                        int sumNumber =  sum[i][j] - sum[k][j] - sum[i][l] + sum[k][l];
                        answer = Math.max(answer, sumNumber);
                    }
                }

            }
        }

        System.out.println(answer);

    }
}