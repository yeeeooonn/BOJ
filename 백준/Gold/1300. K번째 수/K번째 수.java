import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long K = Long.parseLong(br.readLine());

        long start = 1;
        long end = K;

        while(start <= end) {
            long mid = (start+end)/2;

            long count = 0;
            for (int i = 1; i <= N ; i++) {
                count += Math.min(mid/i , N);
            }

            if(count < K) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        System.out.println(start);

    }
}