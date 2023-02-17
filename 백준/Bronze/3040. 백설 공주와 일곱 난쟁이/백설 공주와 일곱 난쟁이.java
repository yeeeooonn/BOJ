import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N = 9; //난쟁이수
	static int RN = 7; //진짜난쟁이수
	static int[] nums ;
	static int[] nanzang ;
	static boolean[] visited ;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nums = new int[N];
		nanzang = new int[RN];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		combi(0,0,0);
		System.out.println(sb.toString());
		
	}
	static void combi(int cnt, int start, int sum) {
		if(cnt == RN) {
			if(sum==100) {
				for (int i = 0; i < RN; i++) {
					sb.append(nanzang[i]+"\n");
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			visited[i] = true;
			nanzang[cnt] = nums[i];
			combi(cnt+1, i+1 , sum + nums[i]);
			nanzang[cnt] = 0;
			visited[i]= false;
		}
	}
}