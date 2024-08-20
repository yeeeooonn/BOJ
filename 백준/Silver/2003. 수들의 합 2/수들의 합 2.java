import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,result;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int startP = 0;
        int endP = 0;
        int sum = num[0];
        result = 0;

        while(true) {
            if(sum == M) result++;
            if(startP == endP || sum < M) {
                //end포인트 증가
                endP++;
                if(endP >= N) {
                    break;
                }
                sum += num[endP];
            }else {
                sum -= num[startP];
                startP++;
            }
        }
        System.out.println(result);

    }
}