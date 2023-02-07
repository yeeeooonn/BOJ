import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static boolean[] visit;
	static int[] nums;
	static int[] p;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		p = new int[N];
		nums = new int[M];
		
		for (int i = 0; i < p.length; i++) {
			p[i] = i+1;
		}
		combi(0,0);
		System.out.println(sb.toString());
	}
	static void combi(int start, int n) {
		if(n==M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			nums[n] = p[i];
			combi(i+1,n+1);
			nums[n] = 0;
			visit[i] = false;
		}
	}
}
