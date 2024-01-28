import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] alcol = new long[N];
        long total = 0; //총 막걸리 용량

        for (int i = 0; i < N; i++) {
            alcol[i] = Long.parseLong(br.readLine());
            total += alcol[i];
        }

        //이분탐색으로 1~total 확인

        long start = 0;
        long end = total;

        while (start <= end) {
            long mid = (start + end)/2;

            long count = 0;
            if(mid != 0) {
                for (int i = 0; i < N; i++) {
                    count += alcol[i]/mid;
                }
            }else {
                count = K;
            }

            if(count < K) {
                //나눠줄 사람 수가 적은 경우 -> 용량 더 적게
                end = mid-1;
            }else {
                //나눠줄사람 수가 같거나 높은 경우 -> 용량 더 크게
                start = mid+1;
            }

        }
        System.out.println(end);

    }
}