import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BigInteger start;
    static BigInteger diff;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        start = BigInteger.valueOf(Long.parseLong(st.nextToken()));
        diff = BigInteger.valueOf(Long.parseLong(st.nextToken()));
        long T = Long.parseLong(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            long op = Long.parseLong(st.nextToken());
            BigInteger a = BigInteger.valueOf(Long.parseLong(st.nextToken()));
            BigInteger b = BigInteger.valueOf(Long.parseLong(st.nextToken()));

            BigInteger startNum = start.add(a.subtract(BigInteger.valueOf(1)).multiply(diff));

            if(op == 1) {
                //명령어가 1인경우
                sb.append(sum(b).subtract(sum(a.subtract(BigInteger.valueOf(1))))).append("\n");

            }else {
                //명령어가 2인경우
                if(a.equals(b)) {
                    sb.append(startNum).append("\n");

                }else {
                    sb.append(startNum.gcd(diff)).append("\n");
                }
            }

        }

        System.out.println(sb.toString());


    }
    static BigInteger sum(BigInteger n) {
        return n.multiply(start.multiply(BigInteger.valueOf(2)).add(n.subtract(BigInteger.valueOf(1)).multiply(diff)))
                .divide(BigInteger.valueOf(2));
    }
}