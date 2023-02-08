import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] card;
	static int[] nums;
	static boolean[] visited;
	static int answer; //정답(세수합)
	static int min = Integer.MAX_VALUE; //차이제일적은값
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		nums = new int[3];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		combi(0,0);
		System.out.println(answer);
	}
	static void combi(int cnt, int start) {
		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += nums[i];
			}
			if(M-sum < min && M-sum>=0) {
				min = M-sum;
				answer = sum;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			visited[i] = true;
			nums[cnt] = card[i];
			combi(cnt+1,i+1);
			nums[cnt] = 0;
			visited[i] = false;
		}
			
	}

}
