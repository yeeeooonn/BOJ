import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    static int[] visited;
    static class Info implements Comparable<Info> {
        int loc;
        int time;
        public Info (int loc, int time) {
            this.loc = loc;
            this.time = time;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.time, o.time);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Info> pq = new PriorityQueue<>();
        visited = new int[200_001];

        pq.offer(new Info(N, 0));
        for (int i = 0; i < 200_001; i++) {
            visited[i] = -1;
        }
        visited[N] = 0;

        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            if(cur.loc == K) {
                System.out.print(cur.time);
                break;
            }

            if(checkRange(cur.loc*2) && checkMin(cur.loc*2, cur.time)) {
                visited[cur.loc*2] = cur.time;
                pq.offer(new Info(cur.loc*2, cur.time));
            }
            if(checkRange(cur.loc+1) && checkMin(cur.loc+1, cur.time)) {
                visited[cur.loc+1] = cur.time+1;
                pq.offer(new Info(cur.loc+1, cur.time+1));
            }
            if(checkRange(cur.loc-1) && checkMin(cur.loc-1, cur.time)) {
                visited[cur.loc-1] = cur.time+1;
                pq.offer(new Info(cur.loc-1, cur.time+1));
            }

        }


    }
    static boolean checkRange(int n) {
        return n>=0 && n<=200_000;
    }
    static boolean checkMin(int n, int t) {
        //한번도 방문 안했거나, 방문했다면 시간이 더 작은경우
        return (visited[n] == -1) || (visited[n] >= 0 && visited[n] > t);
    }
}