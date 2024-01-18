import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int M;
    static int answer = 0;
    static int[][] choice;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            answer = Integer.MAX_VALUE;
            choice = new int[N][3]; //N,0 -> N번째 줄에서 W 만들때 필요한 개수, N,1-> B, N,2 -> R
            for (int n = 0; n < N; n++) {
                String str = br.readLine();
                int white = 0;
                int blue = 0;
                int red = 0;
                for (int i = 0; i < M; i++) {
                    int c = str.charAt(i);
                    if (c == 'W') white++;
                    if (c == 'B') blue++;
                    if (c == 'R') red++;
                }
                choice[n][0] = M-white;
                choice[n][1] = M-blue;
                choice[n][2] = M-red;
            }

            //여기서 1,2,3,...N-1중 2개를 골라야함.(B와 R이 시작하는 줄의 번호)
            for (int b = 1; b < N-1; b++) {
                for (int r = b+1; r < N; r++) {
                    //b -> Blue가 시작하는 줄의 번호, r -> Red가 시작하는 줄의 번호

                    int temp = 0;
                    //흰색 더해줌 -> 0줄 ~ b-1줄
                    for (int i = 0; i < b; i++) {
                        temp += choice[i][0];
                    }
                    //파란색 더해줌 -> b줄 ~ r-1줄
                    for (int i = b; i < r; i++) {
                        temp += choice[i][1];
                    }
                    //빨간색 더해줌 -> r줄 ~ N-1줄
                    for (int i = r; i < N; i++) {
                        temp += choice[i][2];
                    }
                    answer = Math.min(answer,temp);

                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }
}