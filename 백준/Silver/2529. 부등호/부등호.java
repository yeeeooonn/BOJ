import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static boolean[] isSmall;
    static int[] select;
    static boolean[] visited;
    static String answerH;
    static String answerL;
    static long answerh = Long.MIN_VALUE;
    static long answerl = Long.MAX_VALUE;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        isSmall = new boolean[k];
        visited = new boolean[10];
        select = new int[k+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <k ; i++) {
            String op = st.nextToken();
            if(op.equals("<")) {
                isSmall[i] = true;
            }
        }

        perm(0); //순열

        System.out.println(answerH);
        System.out.println(answerL);


    }

    private static void perm(int count) {
        if(count == k+1) {
            if(check(select)) {
                //조건을 만족하면 정답갱신
                StringBuilder num = new StringBuilder();
                for (int i = 0; i <= k; i++) {
                    num.append(select[i]);
                }
                long number = Long.parseLong(String.valueOf(num));
                if(number < answerl) {
                    answerl = number;
                    answerL = String.valueOf(num);

                }
                if(number > answerh) {
                    answerh = number;
                    answerH = String.valueOf(num);
                }

            }


            return;
        }
        for (int i = 0; i < 10; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            select[count] = i;
            perm(count+1);
            select[count] = 0;
            visited[i] = false;

        }

    }

    private static boolean check(int[] select) {
        for (int i = 0; i < k; i++) {
            if((isSmall[i] && select[i] > select[i+1]) || (!isSmall[i] && select[i] < select[i+1])) {
                return false;
            }

        }
        return true;
    }
}