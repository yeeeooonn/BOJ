import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N,X;
	static int result;
	static int[][] map1;
	static int[][] map2;
	static int acc;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map1 = new int[N][N];
			map2 = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map1[i][j] = Integer.parseInt(st.nextToken());
					map2[j][i] = map1[i][j]; 
				}
			}
			
			
			for (int i = 0; i < N; i++) {
				//행 탐색
				acc = 1;
				check(i,0,false,map1);
				
				//열 탐색
				acc =1;
				check(i,0,false,map2);
			}

			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());

	}
	static void check(int row, int col, boolean flag,int[][]map) {
		if(flag == true) {
			if(acc>=X) {
				acc = 0;
				check(row,col,false,map);
				return;
			}
		}
		if(col == N-1) {
			if(flag == false) {
				result++;
			}
			return;
		}
		
		if(map[row][col] == map[row][col+1]) { //다음 높이가 내 높이랑 같은 경우
			acc++;
			check(row,col+1,flag,map);
		}
		if(map[row][col] == map[row][col+1]+1 && flag == false) {//다음 높이가 나보다 1 낮은 경우
			acc =1;
			check(row,col+1,true,map);
		}
		
		if(map[row][col] == map[row][col+1]-1) {//다음 높이가 나보다 1 높은 경우
			if(acc>= X) {
				acc = 1;
				check(row,col+1,flag,map);
			}
		}
		
	}

}
