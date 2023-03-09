import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] hit;
	static int[] p;
	static int[] seq;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		hit = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				hit[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[9];
		p = new int[9];
		seq = new int[9];
		result = 0;
		perm(1);
		System.out.println(result);
		
	}
	static void perm(int cnt) {
		if(cnt == 9) {
			seq = Arrays.copyOf(p, p.length);
			int temp = seq[0];
			seq[0] = seq[3];
			seq[3] = temp;
			
			int cur = 0; //현재 순서
			int answer = 0;
			for (int i = 0; i < N; i++) {
				boolean is1 = false;
				boolean is2 = false;
				boolean is3 = false;
				int out = 0;
				while(out<3) {
					if(cur == 9) cur = 0;
					if(hit[i][seq[cur]] == 0) {
						out++;
						cur++;
						continue;
					}
					if(hit[i][seq[cur]] == 1) {
						if(is3) {
							answer++;
							is3 = false;
						}
						if(is2) {
							is3 = true;
							is2 = false;
						}
						if(is1) {
							is2 = true;
						}
						is1 = true;
					}
					if(hit[i][seq[cur]] == 2) {
						if(is3) {
							answer++;
							is3 = false;
						}
						if(is2) {
							answer++;
							is2 = false;
						}
						if(is1) {
							is3 = true;
							is1 = false;
						}
						is2 = true;
					}
					if(hit[i][seq[cur]] == 3) {
						if(is3) {
							answer++;
							is3 = false;
						}
						if(is2) {
							answer++;
							is2 = false;
						}
						if(is1) {
							answer++;
							is1 = false;
						}
						is3 = true;
					}
					if(hit[i][seq[cur]] == 4) {
						if(is3) {
							answer++;
							is3 = false;
						}
						if(is2) {
							answer++;
							is2 = false;
						}
						if(is1) {
							answer++;
							is1 = false;
						}
						answer ++;
					}
					cur++;
				}
			}
			
			result = Math.max(result, answer);
			return;
		}
		for (int i = 1; i < 9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			p[cnt] = i;
			perm(cnt+1);
			p[cnt] = 0;
			visited[i] = false;
		}
		
	}

}