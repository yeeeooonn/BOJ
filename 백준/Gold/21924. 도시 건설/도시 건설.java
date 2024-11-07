import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
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
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        long total = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(s,e,w));
            total += w;
        }

        parent = new int[N+1]; //부모값 본인 값으로 초기화
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        int count = 0;
        long result = 0;
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(union(cur.s, cur.e)) {
                result += cur.w;
                count++;
                if(count== N-1) break;
            }
        }
        if(count == N-1) {
            System.out.println(total-result);
        }else {
            System.out.println(-1);
        }

    }
    static boolean union(int s, int e) {
        s = find(s);
        e = find(e);
        if(s == e) return false;
        parent[s] = e;
        return true;
    }
    static int find(int num) {
        if(num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }
}