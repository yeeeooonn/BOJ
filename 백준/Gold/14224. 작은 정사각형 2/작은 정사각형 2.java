import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static long[][] location;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        location = new long[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            location[i][0] = Long.parseLong(st.nextToken());
            location[i][1] = Long.parseLong(st.nextToken());
        }


        //이분탐색 - 정사각형 한 변의 길이 기준
        long start = 2;
        long end = 2_000_000_002;
        while(start <= end) {
            long mid = (start+end)/2;

            if(check(mid)) {
                end = mid-1;
            }else {
                start = mid+1;
            }

        }

        System.out.println(start*start);

    }

    private static boolean check(long mid) {

        for (int i = 0; i < N; i++) {
            //x좌표 범위 location[i][0] ~ location[i][0]+mid-2
            long startX = location[i][0];
            long endX = location[i][0]+mid-2;

            for (int j = 0; j < N; j++) {
                long count = 0;
                long startY = location[j][1];
                long endY = location[j][1]+mid-2;

                for (int k = 0; k < N; k++) {
                    if(startX <=location[k][0] && location[k][0]<=endX && startY <=location[k][1] && location[k][1]<=endY) {
                        count++;
                    }
                }
                if(count >= K) return true;

            }

        }
        return false;

    }
}