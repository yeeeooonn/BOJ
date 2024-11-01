import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Edge> list[];
    static int[] distance;
    static boolean[] check;
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
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        for (int i = 0; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e,w));
            list[e].add(new Edge(s,w));
        }


        check = new boolean[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        int count = 0;
        int answer = 0;
        int bigW = 0;
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(check[cur.e]) continue;
            check[cur.e] = true;
            count++;
            answer += cur.w;
            bigW = Math.max(bigW, cur.w);
            if(count == N) break;

            for (Edge next: list[cur.e]) {
                if(!check[next.e]) {
                    pq.offer(next);
                }
            }


        }
        System.out.println(answer-bigW);

    }
}