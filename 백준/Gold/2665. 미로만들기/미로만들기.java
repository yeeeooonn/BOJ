import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static class Edge implements Comparable<Edge>{
        int r;
        int c;
        int w;
        public Edge(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }
        @Override
        public int compareTo(Edge edge) {
            return this.w - edge.w;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0,0,0));
        visited[0][0] = true;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(cur.r == N-1 && cur.c == N-1) {
                System.out.println(cur.w);
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if(!check(nr,nc)) continue;
                if(!visited[nr][nc]) {
                    if(map[nr][nc] == 1) {
                        //흰방일경우
                        pq.offer(new Edge(nr,nc,cur.w));
                    }else {
                        //검은방일경우
                        pq.offer(new Edge(nr,nc,cur.w+1));
                    }
                    visited[nr][nc] = true;
                }

            }


        }

    }
    static boolean check(int nr, int nc) {
        return nr>=0 && nr<N && nc>=0 && nc<N;
    }
}