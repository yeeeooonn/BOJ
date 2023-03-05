import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,S;
	static int[] nums;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int end = 0;
		int sum = nums[0];
		int result = Integer.MAX_VALUE;
		for (int start = 0; start < N; start++) {
			while(end<N && sum < S) {
				end++;
				if(end!=N) {
					sum += nums[end];
				}
			}
			if(end == N) break;
			if(start<=end)
				result = Math.min(result, end-start+1);
			sum -= nums[start];
		}
		System.out.println(result==Integer.MAX_VALUE ? 0 : result);

	}

}