import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,T;
    static int[] parent;
    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int w;
        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Edge edge) {
            return this.w - edge.w;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(s, e, w));
        }

        int count = 0;
        long result = (N-2)*(N-1)/2 * T; //증가비용 미리더하기

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(union(cur.s, cur.e)) {
                count++;
                result += cur.w;
                if(count == N-1) break;
            }

        }

        System.out.println(result);
    }
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return false;
        parent[a] = b;
        return true;
    }
    static int find(int num) {
        if(num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }
 }