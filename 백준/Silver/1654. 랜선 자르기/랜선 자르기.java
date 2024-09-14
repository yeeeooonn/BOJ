import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,K,max;
    static int line[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        line = new int[K];
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            if(line[i] > max) {
                max = line[i];
            }
        }

        long start = 1;
        long end = max;
        while(start <= end) {
            long mid = (start + end)/2;

            long count = check(mid);

            if(count >= N) {
                //N개 이상이면 길이 늘리기
                start = mid+1;
            }else if(count < N){
                end = mid-1;
            }
        }

        System.out.print(end);

    }
    static long check(long num) {
        //num길이로 N개 만들수있으면 true, 아니면 false
        long count = 0;
        for (int i = 0; i < K; i++) {
            count += (line[i] / num);
        }
        return count;
    }

}