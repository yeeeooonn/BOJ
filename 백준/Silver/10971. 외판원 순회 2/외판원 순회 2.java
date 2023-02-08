import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] city;
	static boolean [] visited;
	static int[] nums;
	static int min = Integer.MAX_VALUE;
	static boolean isRoad; //true : 길없다
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		city = new int[N][N];
		visited = new boolean[N];
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
		System.out.println((min == Integer.MAX_VALUE) ? 0:min);

	}
	static void perm(int cnt) {
		if(cnt == N) {
			int sum = 0;
			isRoad = false;
			for (int i = 0; i < N-1; i++) {
				if(city[nums[i]][nums[i+1]] == 0) isRoad = true;
				sum += city[nums[i]][nums[i+1]];
			}
			if(city[nums[N-1]][nums[0]] == 0) isRoad = true;
			sum += city[nums[N-1]][nums[0]];
			
			if(!isRoad) {
				if(min>sum) min = sum;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			nums[cnt] = i;
			perm(cnt+1);
			nums[cnt] = 0;
			visited[i] = false;
		}
		
	}

}
