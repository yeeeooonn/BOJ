import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int nums[];
    static int op[];
    static int select[]; //연산자 선택
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        select = new int[N-1];
        op = new int[4]; //연산자 개수 저장

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);

        System.out.println(max);
        System.out.println(min);

    }
    static void perm(int depth) {
        if(depth == N-1) {
            int cal = nums[0];
            for (int i = 0; i < N-1; i++) {
                if(select[i] == 0) {
                    cal += nums[i+1];
                }else if(select[i] == 1) {
                    cal -= nums[i+1];
                }else if(select[i] == 2) {
                    cal *= nums[i+1];
                }else {
                    cal /= nums[i+1];
                }
            }
            if(cal > max) {
                max = cal;
            }
            if(cal < min) {
                min = cal;
            }

            return;
        }
        for (int i = 0; i < 4; i++) {
            if(op[i] >0) {
                op[i]-=1;
                select[depth] = i;
                perm(depth+1);
                select[depth] = 0;
                op[i]+=1;
            }
        }

    }
}