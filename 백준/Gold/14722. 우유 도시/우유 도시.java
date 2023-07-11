import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; //우유도시 영역 크기
    static int milk[][];
    static int dp[][][];


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        milk = new int[N+1][N+1];
        dp = new int[N+1][N+1][3]; //좌표 (x,y)까지 어떤 우유를 마셨을 때 우유의 최대 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                milk[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //딸기->초코->바나나->딸기


        //초기 세팅
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int color = milk[i][j];

                if(color == 0) {
                    dp[i][j][0] = Math.max(1,dp[i][j][0]);
                }

                int colorN = milk[i+1][j]; // 0: 딸기, 1: 초코, 2: 바나나
                int colorE = milk[i][j+1]; // 0: 딸기, 1: 초코, 2: 바나나

                dp[i+1][j][0] = Math.max(dp[i][j][0], dp[i+1][j][0]);
                dp[i][j+1][0] = Math.max(dp[i][j][0],dp[i][j+1][0]);

                dp[i+1][j][1] = Math.max(dp[i][j][1], dp[i+1][j][1]);
                dp[i][j+1][1] = Math.max(dp[i][j][1],dp[i][j+1][1]);

                dp[i+1][j][2] = Math.max(dp[i][j][2], dp[i+1][j][2]);
                dp[i][j+1][2] = Math.max(dp[i][j][2],dp[i][j+1][2]);

                //남쪽,동쪽
                if(dp[i][j][2] > 0 ) {
                    if (colorN == 0) {
                        dp[i+1][j][0] = Math.max(dp[i][j][2]+1, dp[i+1][j][0]);
                    }
                    if (colorE == 0) {
                        dp[i][j+1][0] = Math.max(dp[i][j][2]+1, dp[i][j+1][0]);
                    }
                }

                if(dp[i][j][0] > 0 ) {
                    if (colorN == 1) {
                        dp[i+1][j][1] = Math.max(dp[i][j][0]+1, dp[i+1][j][1]);
                    }
                    if (colorE == 1) {
                        dp[i][j+1][1] = Math.max(dp[i][j][0]+1, dp[i][j+1][1]);
                    }
                }

                if(dp[i][j][1] > 0) {
                    if (colorN == 2) {
                        dp[i+1][j][2] = Math.max(dp[i][j][1]+1, dp[i+1][j][2]);
                    }
                    if (colorE == 2) {
                        dp[i][j+1][2] = Math.max(dp[i][j][1]+1, dp[i][j+1][2]);
                    }
                }



            }
        }

        System.out.println(Math.max(dp[N-1][N-1][0], Math.max(dp[N-1][N-1][1],dp[N-1][N-1][2])));

    }
}