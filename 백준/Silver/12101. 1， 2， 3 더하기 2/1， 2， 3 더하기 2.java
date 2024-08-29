import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,K,count;
    static int[] select;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        select = new int[11];
        count = 0;
        dfs(0,0);

        if(count < K) {
            sb.append(-1);
        }
        System.out.print(sb);

    }
    static void dfs(int depth, int sum) {
        if(sum == N) {
            count++;
            if(count == K) {
                sb.append(select[0]);
                for (int i = 1; i < 11; i++) {
                    if(select[i]!= 0) {
                        sb.append("+").append(select[i]);
                    }
                }
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if(sum+i <= N) {
                select[depth] = i;
                dfs(depth+1, sum+i);
                select[depth] = 0;
            }
        }
    }
}