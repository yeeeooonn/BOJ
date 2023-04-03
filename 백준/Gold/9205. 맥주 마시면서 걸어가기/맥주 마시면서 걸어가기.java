import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int T,N;
	static int x1,y1,x2,y2; //시작점, 끝점
	static List<int[]> list;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			//시작점
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			list.add(new int[] {x1,y1});
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[] {x,y});
			}
			//끝점
			st = new StringTokenizer(br.readLine());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			list.add(new int[] {x2,y2});
			
			map = new int[N+2][N+2];
			for (int i = 0; i < N+2; i++) {
				for (int j = i; j < N+2; j++) {
					int distx = Math.abs(list.get(i)[0] - list.get(j)[0]);
					int disty = Math.abs(list.get(i)[1] - list.get(j)[1]);
					map[i][j] = map[j][i] = distx+disty;
				}
			}
			
			for (int k = 0; k < N+2; k++) {
				for (int i = 0; i < N+2; i++) {
					for (int j = 0; j < N+2; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]); 
						//map이 1000이하이면(맥주 마셔서 갈 수 있는 거리) 거리 0 처리해주기
						if(map[i][j] <= 1000) {
							map[i][j] = 0;
						}
					}
				}
			}
			
			if(map[0][N+1] == 0) {
				sb.append("happy\n");
			}else {
				sb.append("sad\n");
			}
		}
		System.out.println(sb.toString());
	}

}