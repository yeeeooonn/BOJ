import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] p ;
	static int[] nums ;
	static boolean [] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N];
		visit = new boolean[N];
		nums = new int[M];
		
		for (int i = 0; i < N; i++) {
			p[i] = i+1;
		}
		perm(0);
		System.out.println(sb.toString());
	}
	
	static void perm(int n) {
		if(n == M) {
			for (int i = 0; i < nums.length; i++) {
				sb.append(nums[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visit[i]) continue;
			
			visit[i] = true;
			nums[n] = p[i];
			perm(n+1);
			nums[n] = 0;
			visit[i] = false;
		}	
	}
}
