import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(calc(B)-calc(A-1));

    }
    static long calc(long num) {
        //2로 몇 번 나누어지는지 구하는 함수
        long sum = 0;
        long temp = 0;
        long ex = 1; //지수
        while(num != 0) {
            if(num %2 == 0) {
                temp = num/2;
            }else {
                temp = num/2 +1;
            }
            sum += temp * ex;
            ex *= 2;
            num -= temp;

        }
        return sum;
    }

}