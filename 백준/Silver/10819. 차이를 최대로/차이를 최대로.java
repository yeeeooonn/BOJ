import javax.print.attribute.standard.PresentationDirection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static boolean visited[];
    static int select[];
    static int num[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        select = new int[N];
        result = Integer.MIN_VALUE;

        perm(0);

        System.out.print(result);

    }
    static void perm(int depth) {
        if(depth == N) {
            int cal = 0;
            for (int i = 0; i < N-1; i++) {
                cal += Math.abs(num[select[i]] - num[select[i+1]]);
            }
            if(cal > result) {
                result = cal;
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                select[depth] = i;
                perm(depth+1);
                select[depth] = 0;
                visited[i] = false;
            }
        }
    }
}