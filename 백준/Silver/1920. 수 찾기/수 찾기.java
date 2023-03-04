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
			sb.append(find(Integer.parseInt(st.nextToken()))).append("\n");
		}
		System.out.println(sb.toString());

	}
	static int find(int num) {
		int s = 0;
		int e = N-1;
		while (s<=e) {
			int mid = (s+e)/2;
			if(num < nums[mid]) {
				e = mid-1;
			}
			if(num > nums[mid]) {
				s = mid+1;
			}
			if(num == nums[mid]) {
				return 1;
			}
		}
		return 0;
	}

}