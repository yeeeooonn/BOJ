import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K,L;
	static int[][] board;
	static int[][] direction;
	static int[] dr = {0,1,0,-1}; //오른쪽 방향부터 90도씩 회전 (오, 아, 왼, 위)
	static int[] dc = {1,0,-1,0};
	static int index;
	static int result; //결과값 저장
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) { //사과 board에 1로 표시
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			board[row-1][col-1] = 1;
		}
		L = Integer.parseInt(br.readLine());
		direction = new int[L][2];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			direction[i][0] = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			//오른쪽으로 회전이면 1, 왼쪽으로 회전이면 -1 저장
			if(s.charAt(0) == 'D') direction[i][1] = 1;
			if(s.charAt(0) == 'L') direction[i][1] = -1;
		}
		//다음 회전 인덱스
		index = 0;
		//이동횟수
		result = 0;
		
		go();
		
		System.out.println(result+1);
		
	}
	static void go() {
		int d = 0; //방향
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> snake = new LinkedList<>();
		q.offer(new int[] {0,0});
		snake.offer(new int[] {0,0});
		while(!q.isEmpty()) {
			if(index < L && result == direction[index][0]) {
				d =  Math.floorMod(d+direction[index++][1], 4);
				if(d == -1) d = 3;
			}
			int cur[] = q.poll();
			int nr = cur[0]+ dr[d];
			int nc = cur[1]+ dc[d];
			
			if(!check(nr,nc)) break; //범위벗어나면 break
			if(board[nr][nc] == 2) break; //뱀과 부딪히면 break
			
			if(board[nr][nc] != 1) {
				int tail[] = snake.poll();
				board[tail[0]][tail[1]] = 0;
			}
			
			board[nr][nc] = 2; //뱀
			snake.offer(new int[] {nr,nc});
			q.offer(new int[] {nr,nc});
			result++;
		}
		
		
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}	

}