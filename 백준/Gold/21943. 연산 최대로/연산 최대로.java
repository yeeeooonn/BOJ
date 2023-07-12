import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int P, Q;
	static int[] nums;
	static int answer;
	
	public static void dfs(int index, int[] subset) {
		if (index == N) {
			int result = 1;
			
			for (int i : subset) {
				result *= i;
			}
			
			answer = Math.max(result, answer);
			return;
		}
		
		for (int i = 0; i < Q + 1; i++) {
			subset[i] += nums[index];
			dfs(index + 1, subset);
			subset[i] -= nums[index];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		answer = 0;
        int[] subset = new int[Q + 1];
        subset[0] = nums[0];
		dfs(1, subset);
		
		System.out.println(answer);
	}

}