import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M; //격자크기, 탈영병 수
    static int[][] map;
    static boolean[][] check;
    static int[][] distance;
    static Node[] node;
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};
    static boolean[] visited;
    static int[] select;
    static int answer;
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int w;
        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
        public int compareTo(Node n) {
            return this.w - n.w;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = 0;
        map = new int[N][N];
        node = new Node[6]; //탈영병이 최대 5명이므로, 0 -> 부대, 1~5 -> 탈영병 위치



        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) {
                    node[0] = new Node(i,j,0);
                    map[i][j] = 0; //나중에 톨게이트 계산 방지
                }else if(map[i][j] == 0) {
                    M++;
                    node[M] = new Node(i, j, 0);
                }
            }
        }

        distance = new int[M+1][M+1]; //distance[1][2] -> 1->2탈영병의 최소거리

        for (int i = 0; i <= M; i++) {
            for (int j = i+1; j <= M; j++) {
                distance[i][j] = dijkstra(i, j);
                distance[j][i] = distance[i][j];
            }
        }

        if(M == 0) { //탈영병이 0명인 경우
            System.out.println(0);
        }else {
            //순열로 순서 뽑음
            answer = Integer.MAX_VALUE;
            select = new int[M];
            visited = new boolean[M+1];
            perm(0);

            System.out.println(answer);
        }

    }
    static void perm(int depth) {
        if(depth == M) {
            //계산
            int sum = distance[0][select[0]];
            for (int i = 0; i < M-1; i++) {
                sum += distance[select[i]][select[i+1]];
            }
            sum += distance[select[M-1]][0];
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = 1; i <= M; i++) {
            if(visited[i]) continue;
            select[depth] = i;
            visited[i] = true;
            perm(depth+1);
            visited[i] = false;
            select[depth] = 0;
        }

    }
    static int dijkstra(int start, int end) {
        check = new boolean[N][N];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(node[start].x, node[start].y, 0));
        check[node[start].x][node[start].y] = true;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.x == node[end].x && cur.y == node[end].y) {
                return cur.w;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.x + dr[d];
                int nc = cur.y + dc[d];
                if(!check(nr,nc) || check[nr][nc]) continue;
                check[nr][nc] = true;
                pq.offer(new Node(nr,nc, cur.w + map[nr][nc]));
            }

        }

        return 0;
    }
    static boolean check(int nr, int nc) {
        return nr>= 0 && nr< N && nc>=0 && nc <N;
    }
}