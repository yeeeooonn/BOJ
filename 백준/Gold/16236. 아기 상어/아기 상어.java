import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] sea; //공간
	static boolean[][] visited;
	static int sx,sy; //아기상어 위치
	static int size = 2; //아기상어 크기
	static int acc;
	static int[] dr = {-1,0,0,1}; //위 왼 오 아
	static int[] dc = {0,-1,1,0};
	static int result;
	static List<Fish> list; //물고기 리스트
	static PriorityQueue<Fish> fishq; //선택한 물고기 우선순위 큐
	static boolean isGo;
	static class Fish implements Comparable<Fish>{
		int r;
		int c;
		int s; //사이즈
		public Fish(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
		
		@Override
		public int compareTo(Fish o) {
			int a = bfs(sx,sy,this.r,this.c);
			int b = bfs(sx,sy,o.r,o.c);
			if(a == b) {
				if(this.r == o.r) {
					return Integer.compare(this.c, o.c);
				}
				return Integer.compare(this.r, o.r);
			}
			return Integer.compare(a,b);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sea = new int[N][N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if(sea[i][j] == 9 ) {
					sx = i;
					sy = j;
					sea[i][j] = 0; 
				}
				if(sea[i][j] <9 && sea[i][j] > 0) { //물고기 일 때 리스트에 추가
					list.add(new Fish(i,j,sea[i][j]));
				}
			}
		}

		
		while(isEat()) {
			fishq = new PriorityQueue<Fish>();
			for (int i = 0; i < list.size(); i++) {
				Fish f = list.get(i);
				if(f.s<size && sea[f.r][f.c]!=0) {
					fishq.offer(new Fish(f.r,f.c,f.s));
				}
			}
			//젤 위 큐 뽑음
			if(fishq.size()==0) break;
			Fish min = fishq.poll();
			int minV = bfs(sx,sy,min.r,min.c);
			if(minV == Integer.MAX_VALUE/1000) break;
			else {
				sea[min.r][min.c] =0;
				result += minV;
				sx = min.r; //상어위치 바꿔줌
				sy = min.c;
				acc++;
				if(acc == size) {
					size++;
					acc = 0;
				}
			}
		}

		System.out.println(result);
	}
	
	static int bfs(int r, int c, int rr, int cc) { //시작 행,열 -> 목표 행,열
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[N][N];
		q.offer(new int[] {r,c,0});
		visited[r][c]= true;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				int cnt = cur[2];
				if(!check(nr,nc)) continue;
				if(nr == rr && nc ==cc) {
					return cnt+1;
				}
				if(!visited[nr][nc] && sea[nr][nc] <= size) {
					q.offer(new int[] {nr,nc,cnt+1});
					visited[nr][nc]= true;
				}
			}
		}
		
		return Integer.MAX_VALUE/1000;
	}

	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}
	
	static boolean isEat() { //sea에 먹을 수 있는 물고기가 있는지
		for (int i = 0; i < list.size(); i++) {
			if(sea[list.get(i).r][list.get(i).c] != 0 && list.get(i).s <size) return true;
		}
		return false;
	}
}