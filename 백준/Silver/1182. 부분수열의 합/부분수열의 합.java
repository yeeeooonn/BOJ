import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,S,result;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        subset(0, 0, 0);
        System.out.print(result);

    }
    static void subset(int depth, int sum, int count) {
        if(depth == N) {
            if(sum == S && count != 0) result++;
            return;
        }
        subset(depth+1, sum+num[depth], count+1);
        subset(depth+1, sum, count);
    }
}