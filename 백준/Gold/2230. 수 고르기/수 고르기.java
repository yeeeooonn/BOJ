import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//투포인터
public class Main {
	static int N,M;
	static int[] nums;
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
		
		int start = 0;
		int end = 0;
		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			start = i;
			while(nums[end] - nums[start] < M) {
				if(end == N-1) break;
				end++;
			}
			if(nums[end] - nums[start] >= M) {
				result = Math.min(result, nums[end] - nums[start]);
			}
		}
		System.out.println(result);

	}

}