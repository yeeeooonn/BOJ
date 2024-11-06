import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M,N,sum;
    static boolean[] check;
    static List<Edge> list[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static class Edge implements Comparable<Edge>{
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

        while(true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if(M == 0 && N == 0) break;
            Prim();

        }

        System.out.print(sb.toString());



    }
    static void Prim() throws IOException {
        sum = 0;
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e,w));
            list[e].add(new Edge(s,w));
            sum += w;
        }

        //Prim
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0,0));
        check = new boolean[N];

        int count = 0;
        int answer = 0;
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(check[cur.e]) continue;
            check[cur.e] = true;
            count++;
            answer += cur.w;
            if(count == N) {
                break;
            }

            for(Edge next : list[cur.e]) {
                if(check[next.e]) continue;
                pq.offer(next);
            }

        }

        sb.append(sum-answer).append("\n");

    }
}