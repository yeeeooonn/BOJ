import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M;
    static boolean[][] tile;
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            tile = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    char c = str.charAt(j);
                    if(c == '.') {
                        tile[i][j] = true; //부서진타일: false, 안깨진타일: true
                    }
                }
            }

            sb.append("#").append(t).append(" ");
            sb.append(checkTile());
            sb.append("\n");
        }
        System.out.println(sb);

    }
    static boolean check (int nr, int nc) {
        return nr>=0 && nr<N && nc>=0 && nc<M;
    }
    static String checkTile() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!tile[i][j]) {
                    //부서진 타일이라면 오른쪽, 오른쪽대각선아래, 아래 위치를 확인
                    for (int d = 0; d < 3; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if(!check(nr,nc)) {
                            return "NO";
                        }
                        if(tile[nr][nc]) {
                            return "NO";
                        }else {
                            tile[nr][nc] = true;
                        }
                    }
                }

            }
        }
        return "YES";
    }
}