import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class Main {
    static int N,M,X;
    static int answer;
    static int distanceX[];

    static int distance[];
    static boolean check[];
    static List<Edge> list[];
    static class Edge implements Comparable<Edge> {
        int e;
        int w;
        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Edge e) {
            return this.w- e.w;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e,w));
        }



        distanceX = new int[N+1]; //X ->i 까지의 최소거리
        dijkstra(X, -1);


        answer = 0;
        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            answer = Math.max(answer, dijkstra(i, X) + distanceX[i]);
        }

        System.out.println(answer);

    }
    static int dijkstra (int start, int end) {

        distance = new int[N+1];
        check = new boolean[N+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(check[cur.e]) continue;
            check[cur.e] = true;

            for (Edge next: list[cur.e]) {
                if(!check[next.e] && distance[cur.e] + next.w < distance[next.e]){
                    distance[next.e] = distance[cur.e] + next.w;
                    pq.offer(new Edge(next.e, distance[next.e]));
                }

            }

        }

        if(end == -1) {
            for (int i = 1; i <= N; i++) {
                distanceX[i] = distance[i];
            }

            return 0;
        }

        return distance[end];
    }
}