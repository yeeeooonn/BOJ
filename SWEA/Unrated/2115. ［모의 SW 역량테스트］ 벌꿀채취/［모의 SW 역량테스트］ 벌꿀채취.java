import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N,M,C; //벌통크기, 벌통개수, 꿀채취 최대 양
	static int[][] honey; //벌꿀 정보
	static int[][] profit; //시작점을 선택했을 때 최대 이익 저장
	static int maxNum;
	static boolean[] visited;
	static List<int[]> list;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			honey = new int[N][N];
			profit = new int[N][N-M+1];
			list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) { //위치에서 시작할 때 최댓 값 구함
				for (int j = 0; j < N-M+1; j++) {
					profit[i][j] = maxProfit(i,j);
					list.add(new int[] {i,j,profit[i][j]});
				}
			}
			
			for (int i = 0; i < list.size()-1; i++) {
				for (int j = i+1; j < list.size(); j++) {
					//같은줄에 있는데 거리가 M보다 작을 때
					if(list.get(i)[0] == list.get(j)[0] && Math.abs(list.get(i)[1]- list.get(j)[1]) < M) continue;
					result = Math.max(result,list.get(i)[2]+list.get(j)[2]);
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	static int maxProfit(int r, int c) {
		visited = new boolean[M];
		maxNum = 0;
		subset(r,c,0,0);
		return maxNum;
	}
	static void subset(int r, int c, int sum, int depth) {
		if(depth == M) {
			if(sum <= C) {
				int tot = 0;
				for (int i = 0; i < M; i++) {
					if(visited[i]) {
						tot+= honey[r][c+i-M]*honey[r][c+i-M];
					}
				}
				maxNum = Math.max(maxNum, tot);
			}
			return;
		}
		visited[depth] = true;
		subset(r,c+1,sum+honey[r][c],depth+1);
		visited[depth] = false;
		subset(r,c+1,sum,depth+1);
	}

}