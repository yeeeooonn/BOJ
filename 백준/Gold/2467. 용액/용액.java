import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int startPoint = 0;
        int endPoint = N-1;

        int diff = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = N-1;

        while(startPoint < endPoint) {
            int sum = nums[startPoint] + nums[endPoint];

            if(Math.abs(sum) < diff) {
                answer1 = startPoint;
                answer2 = endPoint;
                diff = Math.abs(sum);
            }
            if(sum < 0) {
                startPoint++;
            }else {
                endPoint--;
            }
        }

        System.out.println(nums[answer1] +" "+nums[answer2]);

    }
}