import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int nums[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int endPoint = 0;
        int sum = nums[0];
        int answer = Integer.MAX_VALUE;

        for (int startPoint = 0; startPoint < N; startPoint++) {
            while(endPoint < N && sum < S) {
                endPoint++;
                if(endPoint!=N) {
                    sum += nums[endPoint];
                }
            }
            if(endPoint == N) break;
            if(startPoint<=endPoint) {
                answer = Math.min(answer, endPoint-startPoint+1);
            }
            sum -= nums[startPoint];
        }
        
        System.out.println(answer == Integer.MAX_VALUE? 0 : answer);

    }
}