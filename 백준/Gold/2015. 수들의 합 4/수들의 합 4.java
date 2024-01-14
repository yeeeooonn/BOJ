import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sum = new int[N+1]; // sum[i] = 1~i까지의 합
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i-1];
        }

        long answer = 0;

        HashMap<Integer,Long> hm = new HashMap<>();
        hm.put(0,1L);

        for (int i = 1; i <= N; i++) {
            int findKeyNum = sum[i] - K;
            if(hm.containsKey(findKeyNum)) {
                answer += hm.get(findKeyNum);
            }

            if(hm.containsKey(sum[i])) {
                hm.put(sum[i], hm.get(sum[i])+1);
            }else {
                hm.put(sum[i], 1L);
            }

        }

        System.out.println(answer);

    }
}