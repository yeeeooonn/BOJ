import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] answer;
    static int result;
    static int result2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new int[11];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        start(1, 0, -1, -1); //몇번째문제인지, 정답개수, 2번째전정답,이전정답

        System.out.println(result);

    }
    static void start(int depth, int count, int before2, int before1) {
        if(depth == 11) {
            result2++;
            if(count >= 5) result++;
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if(before2 == before1 && before1 == i) continue;
            if(answer[depth] == i) {
                start(depth+1, count+1, before1, i);
            }else {
                start(depth+1, count, before1, i);
            }

        }

    }
}