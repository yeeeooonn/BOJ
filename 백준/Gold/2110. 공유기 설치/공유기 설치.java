import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);
        int start = 1;
        int end = house[N-1]-house[0];

        while(start <= end) {
            int mid = (start+end)/2;
            int count = 1; //house[0] 은 공유기 설치

            int keep = house[0];
            for (int i = 1; i < N; i++) {
                if(house[i] - keep >= mid) {
                    count++;
                    keep = house[i];
                }
            }

            if(count < C) {
                end = mid-1;
            }else {
                start = mid+1;
            }

        }
        System.out.println(end);

    }
}