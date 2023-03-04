import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] nums;
	static int result= Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
		
		int start = 0, end = 0;
        int mid = 0;
        for (int i = 0; i < N; i++) {
            start = i;
            end = N;
            while (start != N) {
                mid = (start + end) / 2;
 
                if (nums[mid] - nums[i] == M) {
                    result = M;
                    break;
                }
                if (nums[mid] - nums[i] < M) {
                    start = mid + 1;
                } else if (start == end) {
                	result = Math.min(result, nums[start] - nums[i]);
                    break;
                } else {
                    end = mid;
                }
                
            }
        }
		System.out.println(result);
	}

}