import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int nums[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			nums[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			while(start<end) {
				int temp = nums[end];
				nums[end] = nums[start];
				nums[start] = temp;
				start++;
				end--;
			}
		}

		for (int i = 1; i <= N; i++) {
			sb.append(nums[i]+" ");
		}
		System.out.println(sb.toString());
	}

}