import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isOdd = new boolean[N]; //홀수면 true, 짝수면 false

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num%2 == 1) {
                isOdd[i] = true;
            }
        }


        int count = 0; //홀수 개수 카운트
        int startPoint = 0;
        int endPoint = 0;
        int answer = 0;

        while(true) {
            if(count < K) {
                //K까지 늘림
                if(isOdd[endPoint]) {
                    count++;
                }
                endPoint += 1;
                answer = Math.max(answer, endPoint - startPoint - count);

            } else if(!isOdd[endPoint]) {
                //count == K, 짝수일 경우
                endPoint += 1;
                answer = Math.max(answer, endPoint - startPoint - count);

            }else {
                //count 가 K를 넘는 경우, count==K && 뒤가 바로 홀수 인경우
                //앞 숫자를 떙김
                if(isOdd[startPoint]) {
                    count--;
                }
                startPoint += 1;

            }
            if(endPoint == N) {
                break;
            }

        }

        System.out.println(answer);

    }
}