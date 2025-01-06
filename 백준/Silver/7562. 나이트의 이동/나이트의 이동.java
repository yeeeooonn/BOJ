import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N,startX,startY,endX,endY;
    static StringTokenizer st;
    static StringBuilder sb;
    static boolean[][] visited;
    static int[] dr = {1,2,2,1,-1,-2,-2,-1};
    static int[] dc = {2,1,-1,-2,-2,-1,1,2};
    static class Edge {
        int x;
        int y;
        int count;

        public Edge(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            visited =new boolean[N][N];
            bfs();

        }

        System.out.print(sb);
    }

    static void bfs() {
        Queue<Edge> q = new LinkedList<>();
        q.offer(new Edge(startX, startY, 0));

        while(!q.isEmpty()) {
            Edge cur = q.poll();
            if(cur.x == endX && cur.y == endY) {
                sb.append(cur.count).append("\n");
                return;
            }

            for (int d = 0; d < 8; d++) {
                int nr = cur.x + dr[d];
                int nc = cur.y + dc[d];
                if(!check(nr,nc) || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.offer(new Edge(nr,nc,cur.count+1));
            }
        }

    }
    static boolean check(int nr, int nc) {
        return nr>= 0 && nr<N && nc>=0 && nc<N;
    }
}