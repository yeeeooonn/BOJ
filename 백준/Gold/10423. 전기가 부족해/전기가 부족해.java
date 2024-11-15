import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static int[] parent;
    static boolean[] isStation;
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
        K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        isStation = new boolean[N+1]; //발전소여부 체크
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            isStation[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(s,e,w));
        }

        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        int count = 0;
        int answer = 0;
        while(!pq.isEmpty() || count != N-K) {
            Edge cur = pq.poll();
            if(union(cur.s, cur.e)) {
                count++;
                answer += cur.w;
            }
        }
        System.out.println(answer);

    }
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return false;
        if(isStation[a] && isStation[b]) return false; //서로 다른 발전소가 연결되어있는 경우

        if(isStation[a]) {
            //a가 발전소면 b의 부모를 a로 (발전소와 연결되어있는 경우 발전소를 무조건 부모로 가지게)
            parent[b] = a;
        }else {
            parent[a] = b;
        }
        return true;

    }
    static int find(int num) {
        if(parent[num] == num) return num;
        else return parent[num] = find(parent[num]);
    }
}