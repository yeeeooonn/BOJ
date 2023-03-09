import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static B[] nums;
	static class B implements Comparable<B> {
		int value;
		int index;
		@Override
		public int compareTo(B o) {
			return Integer.compare(this.value, o.value);
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new B[N];
		for (int i = 0; i < N; i++) {
			nums[i] = new B();
			nums[i].value = Integer.parseInt(br.readLine());
			nums[i].index = i;
		}
		Arrays.sort(nums);
		int max = 0;
		for (int i = 0; i < N; i++) {
			if(max < nums[i].index - i) {
				max = nums[i].index - i;
			}
		}
		System.out.println(max+1);
	}

}