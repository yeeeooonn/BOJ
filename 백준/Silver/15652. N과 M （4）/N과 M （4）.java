import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[M];
        perm(0,1);

        System.out.print(sb);
    }
    static void perm(int depth, int start) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(visited[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            visited[depth] = i;
            perm(depth+1, i);
            visited[depth] = 0;
        }

    }
}