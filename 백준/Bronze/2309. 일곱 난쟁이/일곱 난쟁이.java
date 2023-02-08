import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] height;
	static int[] nums;
	static int N = 9;
	static int M = 7;
	static boolean isFound;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		height = new int[N];
		nums = new int[M];
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		
		combi(0,0);

	}
	static void combi(int cnt, int start) {
		if(isFound == true) return;
		if(cnt == M) {
			int sum = 0;
			for (int i = 0; i < M; i++) {
				sum += nums[i];
			}
			if(sum == 100) {
				Arrays.sort(nums);
				for (int i = 0; i < M; i++) {
					System.out.println(nums[i]);
				}
				isFound = true;
			}
			
			return;
		}
		for (int i = start; i < N; i++) {
			nums[cnt] = height[i];
			combi(cnt+1,i+1);
			nums[cnt] = 0;
		}
	}

}
