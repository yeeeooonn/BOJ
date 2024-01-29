import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static long K;
    static long[] food;
    static Long [] people;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Long.parseLong(st.nextToken());
            people = new Long[N];
            food = new long[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                people[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                food[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(food); //오름차순
            Arrays.sort(people, Collections.reverseOrder()); //내림차순

            long start = 0;
            long end = food[N-1] * people[0];

            while(start <= end) {
                long mid = (start+end)/2;
                long count = 0;

                for (int i = 0; i < N; i++) {
                    count += Math.max(people[i] - mid / food[i],0);
                }

                if(count <= K) {
                    end = mid -1;
                }else {
                    start = mid+1;
                }

            }

            sb.append("#").append(t).append(" ").append(start).append("\n");
        }

        System.out.println(sb);


    }
}