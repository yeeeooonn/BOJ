import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][]map;
	static int[]choice;
	static int[][] chicken;
	static int count;
	static int sum;
	static int tot= Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		choice = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==2) count++; //치킨집 개수 카운트
			}
		}
		chicken = new int[count][2];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] ==2) {
					chicken[cnt][0] = i;
					chicken[cnt++][1] = j;
				}
			}
		}
		
		//치킨집중 M개 고르기
		combi(0,0);
		System.out.println(tot);
	}
	static void combi(int cnt, int start) {
		if(cnt == M) {
			//고른것들 중 최솟값 구하기
			min();
			tot = Math.min(sum, tot);
			return;
		}
		for (int i = start; i < count; i++) {
			choice[cnt] = i;
			combi(cnt+1,i+1);
			choice[cnt] = 0;
		}
	}
	static void min() {
		sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					int minDis = Integer.MAX_VALUE;
					for (int c = 0; c < M; c++) {
						//집마다 치킨집과의 거리 중 가까운것으로 sum에 더해줌
						int dis = Math.abs(chicken[choice[c]][0]-i) + Math.abs(chicken[choice[c]][1]-j);
						minDis = Math.min(minDis, dis);
					}
					sum += minDis;
				}
			}
		}
	}
}