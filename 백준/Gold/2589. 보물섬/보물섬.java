import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R,C,result;
    static int[][] map; //1:바다, 0:육지
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if(str.charAt(j) == 'W') {
                    map[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 0) {
                    bfs(i,j);
                }
            }
        }

        System.out.println(result);

    }
    static void bfs(int n, int r) {
        visited = new boolean[R][C];
        visited[n][r] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {n,r,0});

        while(!q.isEmpty()) {
            int cur[] = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(!check(nr,nc)) continue;
                if(map[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc, cur[2]+1});
                    if(result < cur[2]+1) {
                        result = cur[2]+1;
                    }

                }

            }

        }

    }
    static boolean check(int nr, int nc) {
        return nr>=0 && nr<R && nc>=0 && nc<C;
    }
}