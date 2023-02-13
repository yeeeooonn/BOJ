import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int N;
	static int[][] map;
	static int[] dr = {-1,0,1,0}; //상우하좌
	static int[] dc = {0,1,0,-1};
	static int cnt; //그룹 수
	static LinkedList<Integer> count;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		count = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}

		cnt =0;
		count.add(0,-1);
		count.add(1,-1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					cnt++;
					count.add(cnt+1,1);
					dfs(i,j,cnt+1);
				}
			}
		}
		System.out.println(cnt); //그룹의 개수
		count.sort((a,b)->(a-b));
		
		for (Integer i : count) {
			if(i==-1)continue;
			System.out.println(i);
		}	

	}
	//1로 상하좌우로 연결된 것을 g로 만든다
	static void dfs(int r , int c, int g) {
		map[r][c] =g;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!check(nr,nc)) continue;
			if(map[nr][nc] ==1) {
				count.set(g, count.get(g)+1);
				dfs(nr,nc,g);
			}
		}
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}

}