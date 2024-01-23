import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(nums);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = i+3; j < N; j++) {
                int start = i+1;
                int end = j-1;

                while(start < end) {
                    int sumA = nums[i] + nums[j];
                    int sumB = nums[start] + nums[end];

                    answer = Math.min(answer, Math.abs(sumA-sumB));

                    if(sumA < sumB) {
                        end--;
                    }else {
                        start++;
                    }

                }
            }

        }


        System.out.println(answer);

    }
}