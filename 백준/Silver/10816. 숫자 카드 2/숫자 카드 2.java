import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int nums[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int start= findS(target);
			int end = findE(target);
			sb.append(end-start).append(" ");
		}
		
		System.out.println(sb.toString());

	}
	static int findE(int target) {
		int s = 0;
		int e = N;
		while(s<e) {
			int mid = (s+e)/2;
			if(target < nums[mid]) {
				e = mid;
			}
			if(target>= nums[mid]) {
				s = mid+1;
			}
		}
		return s;
	}
	static int findS(int target) {
		int s = 0;
		int e = N;
		while (s<e) {
			int mid = (s+e)/2;
			if(target <= nums[mid]) {
				e = mid;
			}
			if(target > nums[mid]) {
				s = mid+1;
			}
		}
		return s;
	}

}