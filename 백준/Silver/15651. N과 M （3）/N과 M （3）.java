import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        //N개 중 M개 중복순열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[M];

        perm(0);
        System.out.print(sb);

    }
    static void perm(int depth) {
        if(depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(visited[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            visited[depth] = i;
            perm(depth+1);
            visited[depth] = 0;
        }

    }
}