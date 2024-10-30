import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<E>[] list;
    static int[] distance;
    static boolean[] check;
    static class E implements Comparable<E>{
        int e;
        int w;
        public E(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(E e) {
            return this.w - e.w;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new E(e,w));
            list[e].add(new E(s,w));
        }


        distance = new int[N+1];
        Arrays.fill(distance,INF);
        check = new boolean[N+1];

        PriorityQueue<E> pq = new PriorityQueue();
        distance[1] = 0;
        pq.offer(new E(1,0));
        while(!pq.isEmpty()) {
            E cur = pq.poll();
            if(check[cur.e]) continue;

            check[cur.e] = true;
            for (E next : list[cur.e]) {
                if(!check[next.e] && distance[cur.e] + next.w < distance[next.e]) {
                    distance[next.e] = distance[cur.e] + next.w;
                    pq.offer(new E(next.e, distance[next.e]));
                }

            }

        }
        System.out.println(distance[N]);

    }
}