import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] nums;
	static int min;
	static int left,right;
	static int resultl,resultr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		left = 0;
		right = N-1;
		
		while(left<right) {
			int sum = nums[left]+nums[right];
			if(sum == 0) {
				System.out.println(nums[left]+" "+nums[right]);
				return;
			}
			
			if(Math.abs(sum) < min) { //차이가 더 작다면
				min = Math.abs(sum);
				resultl = nums[left];
				resultr = nums[right];
			}
			
			if(sum < 0) {
				left++;
			}else {
				right--;
			}
		}
		System.out.println(resultl+" "+resultr);

	}

}