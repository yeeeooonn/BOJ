import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] arr;
    static int N;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1][11]; //1,1 ~ i,j 까지의 특정 숫자 개수

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                for (int k = 1; k <= 10; k++) {
                    //자신 기준 왼쪽 + 위쪽 - 왼쪽위대각선
                    arr[i][j][k] = arr[i-1][j][k] + arr[i][j-1][k] - arr[i-1][j-1][k];
                }
                arr[i][j][num]++; //본인 숫자에 증가
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            solution(x1,y1,x2,y2);
        }

        System.out.println(sb);

    }
    static void solution(int x1, int y1, int x2, int y2) {
        int result = 0;
        answer = new int[11];
        for (int i = 1; i <= 10; i++) {
            answer[i] = arr[x2][y2][i];
            answer[i] -= arr[x2][y1-1][i];
            answer[i] -= arr[x1-1][y2][i];
            answer[i] += arr[x1-1][y1-1][i];
        }

        for (int i = 1; i <= 10; i++) {
            if(answer[i] > 0) {
                result++;
            }
        }
        sb.append(result).append("\n");

    }
}