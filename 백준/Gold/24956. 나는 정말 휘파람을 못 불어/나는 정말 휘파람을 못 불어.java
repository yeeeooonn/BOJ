import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long mod = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        long answer = 0;
        long eCount = 0;
        long keepNum = 0;
        for (int i = N-1; i >= 0 ; i--) {
            char c = str.charAt(i);
            if(c == 'E') {
                eCount++;
            }else if(c == 'H') {
                if(eCount >=2) {
                    keepNum += ((pow(2,eCount) - 1 - eCount)%mod);
                    keepNum %= mod;
                }
            }else if(c == 'W') {
                answer += (keepNum%mod);
                answer %= mod;

            }

        }
        System.out.println(answer);

    }
    private static long pow(long base, long ex) {
        long result = 1;
        while (ex > 0) {
            if (ex % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            ex /= 2;
        }
        return result;
    }
}