import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static boolean[] select;
    static boolean[][] check;
    static int answer = Integer.MAX_VALUE;
    static int total;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        select = new boolean[N];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String result = st.nextToken();
            for (int j = 0; j < M; j++) {
                char c = result.charAt(j);
                if(c == 'Y') check[i][j] = true;
            }

        }

        //부분집합
        subset(0, 0); //깊이, 카운트

        if(answer == 0){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }

    }
    static void subset(int depth, int count) {
        if(depth == N) {
            int mCount = musicCount(); //음악을 얼마나 연주 가능한지
            if (total < mCount) { //total : 현재까지 나온 음악 최대 수
                total = mCount;
                answer = count;
            }else if(total ==  mCount) {
                answer = Math.min(answer, count);
            }
            return;
        }
        //선택함
        select[depth] = true;
        subset(depth+1, count+1);

        //선택안함
        select[depth] = false;
        subset(depth+1, count);
    }

    private static int musicCount() {
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(select[j] && check[j][i]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}