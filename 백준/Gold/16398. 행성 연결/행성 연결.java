import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] input;
    static List<Edge> list[];
    static boolean[] check;
    static class Edge implements Comparable<Edge> {
        int e;
        int w;
        public Edge(int e, int w) {
            this.e = e;
            this.w =w;
        }
        @Override
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }


        input = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                list[i].add(new Edge(j, input[i][j]));
            }
        }


        //Prim
        System.out.println(Prim());


    }
    static long Prim(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0,0));
        check = new boolean[N];

        int count = 0;
        long answer = 0;
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(check[cur.e]) continue;
            check[cur.e] = true;
            count++;
            answer += cur.w;

            if(count == N) {
                return answer;
            }

            for (Edge next: list[cur.e]) {
                if(!check[next.e]) {
                    pq.offer(next);
                }
            }

        }

        return 0;
    }

}