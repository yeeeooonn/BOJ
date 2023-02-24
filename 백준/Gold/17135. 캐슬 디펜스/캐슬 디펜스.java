import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//미완~^^
public class Main {
	static int N,M,D;
	static int[][] map;
	static int[][] mapCopy;
	static int[][] mapNext;
	static int result;
	static int[] bower;
	static int bowNum = 3;
	static int[] dr = {0,-1,0}; //왼 위 오
	static int[] dc = {-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		mapCopy = new int[N+1][M];
		mapNext = new int[N+1][M];
		bower = new int[bowNum];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combi(0,0);
		System.out.println(result);
		
		
	}
	static void combi(int cnt, int start) {
		if(cnt == bowNum) {
			//map -> mapNext복사
			for (int i = 0; i < N+1; i++) {
				System.arraycopy(map[i], 0, mapNext[i], 0, map[0].length);
			}
			int answer = 0;
			while(!isEnd()) {
				//mapNext -> mapCopy복사
				for (int i = 0; i < N+1; i++) {
					System.arraycopy(mapNext[i], 0, mapCopy[i], 0, mapNext[0].length);
				}
				
				List<int[]> dList = new ArrayList<>();
				for (int i = 0; i < bowNum; i++) {
					boolean[][] visited = new boolean[N+1][M];
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] {N,bower[i]});
					visited[N][bower[i]] = true;
					
					a:
					while(!q.isEmpty()) {
						int cur[] = q.poll();
						for (int d = 0; d < 3; d++) {
							int nr = cur[0] + dr[d];
							int nc = cur[1] + dc[d];
							if(!check(nr,nc)) continue;
							if(visited[nr][nc]) continue;
							if(Math.abs(nr-N)+ Math.abs(nc-bower[i]) <= D && mapCopy[nr][nc]==1) {
								//적만남
								dList.add(new int[] {nr,nc});
								break a;
							}
							if(Math.abs(nr-cur[0])+ Math.abs(nc-cur[1]) <= D && mapCopy[nr][nc]==0) {
								visited[nr][nc] = true;
								q.offer(new int[] {nr,nc});
							}
						}
						
					}
				}
				//공격할 수 있는 적들 mapNext에서 제거
				for (int i = 0; i < dList.size(); i++) {
					int r = dList.get(i)[0];
					int c = dList.get(i)[1];
					if(mapCopy[r][c] ==1) { //이처리 안해주면 답 중복 가능
						answer++;
						mapCopy[r][c] = 0;
					}
				}
				//mapNext 초기화
				mapNext = new int[N+1][M];
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if(mapCopy[i][j] ==1) {
							mapNext[i+1][j] = 1;
						}
					}
				}
			}
			result = Math.max(result, answer);
			return;
		}
		for (int i = start; i < M; i++) {
			bower[cnt] = i;
			combi(cnt+1,i+1);
			bower[cnt] = 0;
		}
	}
	static boolean isEnd() {
		// 1이 있는지 확인
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < M; j++) {
				if(mapNext[i][j] ==1) return false;
			}
		}
		return true;
	}

	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<M;
	}

}