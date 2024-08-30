import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int nums[];
    static int MAX_NUM = 2_000_000;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        check = new boolean[MAX_NUM];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        subset(0, 0);

        for (int i = 1; i < MAX_NUM; i++) {
            if(!check[i]) {
                System.out.println(i);
                break;
            }
        }
    }
    static void subset(int depth, int sum) {
        if(depth == N) {
            check[sum] = true;
            return;
        }

        subset(depth + 1, sum+nums[depth]);
        subset(depth + 1, sum);
    }
}
