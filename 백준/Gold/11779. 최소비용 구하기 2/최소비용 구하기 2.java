import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static List<Edge> list[];
    static int[] distance;
    static boolean[] check;
    static int[] preCity;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e,w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        StringBuilder sb = new StringBuilder();
        sb.append(dijkstra(start, end)).append("\n");

        //지나온 곳 찾기
        Stack<Integer> s = new Stack<>();
        s.push(end);
        int target = end;
        while(target != start) {
            s.push(preCity[target]);
            target = preCity[target];
        }
        sb.append(s.size()).append("\n");
        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb);


    }
    static int dijkstra(int start, int end) {
        distance = new int[N+1];
        preCity = new int[N+1];
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
                if(!check[next.e] && distance[cur.e] + next.w < distance[next.e]) {
                    distance[next.e] = distance[cur.e] + next.w;
                    preCity[next.e] = cur.e; // 이전마을 기록
                    pq.offer(new Edge(next.e, distance[next.e]));
                }

            }

        }

        return distance[end];

    }
}