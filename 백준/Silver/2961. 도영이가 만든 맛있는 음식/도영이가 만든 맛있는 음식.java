import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] food;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		food = new int[N][2];
		visited = new boolean[N];
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}
		power(0,0,1);
		System.out.println(answer);
	}
	static void power(int cnt, int tot, int mul) {
		if(cnt == N) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				if(visited[i] == false) count++;
			}
			if(count == N) {
				return;
			}
			int sub = Math.abs(tot-mul);
			if(sub < answer) answer = sub;
			return;
		}
		visited[cnt] = true;
		power(cnt+1,tot+food[cnt][1],mul*food[cnt][0]);
		visited[cnt] = false;
		power(cnt+1,tot,mul);
	}

}
