import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static long answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Long> Amap = new HashMap<>();
        HashMap<Integer, Long> Bmap = new HashMap<>();

        int[] sumA = new int[n+1]; // sum[i] = 1~i까지의 합
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            sumA[i] = Integer.parseInt(st.nextToken()) + sumA[i-1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int key = sumA[i] - sumA[i - j];

                if (Amap.containsKey(key)) {
                    Amap.put(key, Amap.get(key) + 1);
                } else {
                    Amap.put(key, 1L);
                }

            }

        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] sumB = new int[m+1]; // sum[i] = 1~i까지의 합

        for (int i = 1; i <= m; i++) {
            sumB[i] = Integer.parseInt(st.nextToken()) + sumB[i-1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= i; j++) {
                int key = sumB[i] - sumB[i - j];

                if (Bmap.containsKey(key)) {
                    Bmap.put(key, Bmap.get(key) + 1);
                } else {
                    Bmap.put(key, 1L);
                }

            }

        }

        Amap.forEach((key,value) -> {
            int needKey = T - key;
            if(Bmap.containsKey(needKey)) {
                answer += (value* Bmap.get(needKey));
            }
        });

        System.out.println(answer);

    }
}