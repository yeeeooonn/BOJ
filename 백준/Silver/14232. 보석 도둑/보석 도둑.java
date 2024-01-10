import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long sum;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        sb = new StringBuilder();

        check(N);
        System.out.println(sum+1);
        System.out.println(sb.toString());

    }
    static void check(long num) {
        for(int i = 2; i<= Math.sqrt(num); i++) {
            if(num%i == 0) {
                sum++;
                sb.append(i).append(" ");
                check(num/i);
                return;
            }
        }
        sb.append(num);
    }
}