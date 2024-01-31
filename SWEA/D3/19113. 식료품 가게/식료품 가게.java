import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            long[] price = new long[N*2];
            boolean[] check = new boolean[N*2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2*N; i++) {
                price[i] = Long.parseLong(st.nextToken());
            }

            for (int i = 2*N-1; i >= 0 ; i--) {
                if(!check[i]) { //사용했는지 확인
                    long discount = price[i]*3/4;
                    for (int j = i-1; j >= 0 ; j--) {
                        if(price[j] == discount && !check[j]) {
                            check[j] = true;
                            break;
                        }
                    }

                }
            }


            sb.append("#").append(t).append(" ");
            for (int i = 0; i < 2*N; i++) {
                if(check[i]) {
                    sb.append(price[i]).append(" ");
                }
            }
            sb.append("\n");

        }

        System.out.println(sb);
    }
}