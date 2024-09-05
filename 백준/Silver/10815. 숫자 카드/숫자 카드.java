import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if(find(Integer.parseInt(st.nextToken()))) {
                sb.append(1).append(" ");
            }else {
                sb.append(0).append(" ");
            }
        }
        System.out.print(sb);

    }
    static boolean find(int point) {
        int start = 0;
        int end = N-1;

        while(start < end) {
            int mid = (start + end)/2;

            if(num[mid] < point) {
                start = mid+1;
            }else {
                end = mid;
            }

        }
        if(point == num[start]) {
            return true;
        }else {
            return false;
        }
    }
}