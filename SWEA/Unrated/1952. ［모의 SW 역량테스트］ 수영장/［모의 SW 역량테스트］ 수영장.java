import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static StringBuilder sb = new StringBuilder();
	static int[] costs; //1일, 1달, 3달, 1년 이용권 가격
	static int[] plan;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			costs = new int[4];
			plan = new int[12];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				costs[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = Integer.MAX_VALUE;
			dfs(0,0);
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
	static void dfs(int i, int cost) {
		if(i == 12) {
			answer = Math.min(answer, cost);
			if(answer>costs[3]) answer = costs[3]; //1년이용권 가격보다 클 경우
			return;
		}
		if(plan[i]== 0) {
			dfs(i+1,cost);
		}
		//1일 이용권
		dfs(i+1, cost+plan[i]*costs[0]);
		//1달 이용권
		dfs(i+1, cost+costs[1]);
		if(i < 10) {
			//3달 이용권
			dfs(i+3, cost+costs[2]);
		}
	}
}