import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Long M;
    static int max;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int start = 0;
        int end = tree[N-1];

        while(start < end) {
            int mid = (start + end)/2;
            if(check(mid)) {
                start = mid+1;
            }else {
                end = mid;
            }

        }

        System.out.println(start-1);
    }
    static boolean check (int h) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if(tree[i] - h > 0) {
                sum += (tree[i]- h);
            }
        }
        return sum>=M;
    }
}