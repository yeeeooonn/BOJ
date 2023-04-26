import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 숨바꼭질 4 문제 - 13913번
public class Main {

    static int N, K;
    static int time;
    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){ //시작점=끝점 일 경우
            sb.append(0).append("\n");
            sb.append(N).append("\n");
        }else {
            bfs(N);
            sb.append(time).append("\n");

            //스택을 이용해서 부모를 넣고 차례로 뺀다.
            Stack<Integer> s = new Stack<>();
            s.add(K);
            int index = K;
            while (index != N) {
                s.push(parent[index]);
                index = parent[index];
            }

            while (!s.isEmpty()) {
                sb.append(s.pop()).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    static void bfs(int start) {
        time = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            // 만난 경우
            if(visited[K]) {
                return;
            }

            // q 사이즈 만큼만 돌림
            for(int j = 0, size = q.size(); j < size; j++) {
                int now = q.poll();
                int next;

                //-1인 경우
                next = now - 1;
                if(next >= 0 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    q.offer(next);
                }

                //+1인경우
                next = now + 1;
                if(next < 100001 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    q.offer(next);
                }

                //x2인경우
                next = now * 2;
                if(next < 100001 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    q.offer(next);
                }
            }
            time++;
        }
    }
}