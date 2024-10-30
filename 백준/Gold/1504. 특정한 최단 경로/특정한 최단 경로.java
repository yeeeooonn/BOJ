import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,E;
    static final int INF = 200_000_000;
    static int[] distance;
    static boolean[] check;
    static ArrayList<Edge>[] list;
    static class Edge implements Comparable<Edge> {
        int e;
        int w;
        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }

    }
    public static void main(String[] args) throws Exception{
        // 2,3 을 지나야 하는 경우
        // 1->2, 2 ->3, 3 -> N 까지의 최소 거리를 구해서 더하기
        // 1-> 3, 3 -> 2, 2 ->N까지의 최소 거리를 구해서 더하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e,w));
            list[e].add(new Edge(s,w));
        }

        st = new StringTokenizer(br.readLine());
        int A1 = Integer.parseInt(st.nextToken());
        int A2 = Integer.parseInt(st.nextToken());

        int answer1 = 0;
        answer1 += dijkstra(1, A1);
        answer1 += dijkstra(A1, A2);
        answer1 += dijkstra(A2, N);

        int answer2 = 0;
        answer2 += dijkstra(1, A2);
        answer2 += dijkstra(A2, A1);
        answer2 += dijkstra(A1, N);



        if(answer1 >= INF && answer2 >= INF){
            System.out.println(-1);
        }else {
            System.out.println(Math.min(answer1, answer2));
        }

    }
    static int dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance = new int[N+1];
        check = new boolean[N+1];
        Arrays.fill(distance,INF);

        distance[start] = 0;
        pq.offer(new Edge(start, 0));
        while(!pq.isEmpty()) {

            Edge cur = pq.poll();
            if(check[cur.e]) continue;
            check[cur.e] = true;

            for (Edge next: list[cur.e]) {
                if(!check[next.e] && distance[cur.e] + next.w < distance[next.e]) {
                    distance[next.e] = distance[cur.e] + next.w;
                    pq.offer(new Edge(next.e, distance[next.e]));
                }
            }

        }


        return distance[end];
    }
}