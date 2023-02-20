import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int D,W,K;
	static int[][] film;
	static int[][] filmMake;
	static StringBuilder sb = new StringBuilder();
	static int count;
	static int[] visitRow; // 0: A, 1: B, -1: 선택X
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			filmMake = new int[D][W];
			visitRow = new int[D];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = K; //K가 최대값
			
			dfs(0,0);

			sb.append("#"+t+" "+result+ "\n");
		}
		System.out.println(sb.toString());
	}
	static void dfs(int depth, int count) {
		if(count>= result)
			return;
		if(depth == D) {
			//K개만큼 두꺼운지
			//복사
			for (int i = 0; i < D; i++) {
				System.arraycopy(film[i], 0, filmMake[i], 0, film[0].length);
			}
			for (int i = 0; i < D; i++) {
				if(visitRow[i] == 0) {
					for (int j = 0; j < W; j++) {
						filmMake[i][j] = 0;
					}
				}
				if(visitRow[i] == 1) {
					for (int j = 0; j < W; j++) {
						filmMake[i][j] = 1;
					}
				}
			}
			if(isSuccess()) {
				result = Math.min(result, count);
			}
			return;
		}
		
		
		visitRow[depth] = 0;
		dfs(depth+1,count+1);
		
		visitRow[depth] = 1;
		dfs(depth+1,count+1);
		
		visitRow[depth] = -1;
		dfs(depth+1,count);
		
	}
	static boolean isSuccess() {
		for (int i = 0; i < W; i++) {
			int before = -1;
			int acc = 0;
			for (int j = 0; j < D; j++) {
				if(before == filmMake[j][i])
					acc++;
				if(acc==K-1)
					break;
				if(before != filmMake[j][i]) {
					before = filmMake[j][i];
					acc = 0;
				}
				if(j == D-1)
					return false;
			}
		}
		return true;
	}

}