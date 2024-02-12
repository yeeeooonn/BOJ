import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N, K, answer;
    static int[][] map;
    static int[][] dp;
    static HashMap<Integer, List<P>> hm;
    static class P{
        int r;
        int c;
        public P(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        for (int t = 1; t <= T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            hm = new HashMap<>();

            for (int i = 1; i <= K; i++) { //해시 맵에 좌표 저장
                hm.put(i, new ArrayList<>());
            }


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] <= K) {
                        hm.get(map[i][j]).add(new P(i,j));
                    }
                }
            }

            dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j] = K * 100;
                    if(map[i][j] == 1) {
                        dp[i][j] = 0;
                    }
                }
            }


            for (int i = 2; i <= K; i++) {
                //2부터 K까지 본인과 본인 전을 찾아서 최소 거리를 저장
                for (P cur : hm.get(i)) {
                    for (P prev : hm.get(i-1)) {
                        dp[cur.r][cur.c] = Math.min(dp[cur.r][cur.c], dp[prev.r][prev.c] + Math.abs(prev.r - cur.r) + Math.abs(prev.c - cur.c));
                    }
                }

            }

            answer = K * 100;

            for (P a : hm.get(K)) {
                answer = Math.min(answer, dp[a.r][a.c]);
            }

            if(answer == K * 100) {
                answer = -1;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);


    }
}