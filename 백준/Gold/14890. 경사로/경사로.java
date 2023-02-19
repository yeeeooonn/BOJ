import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,L;
	static int[][] map;
	static int result;
	static int acc;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//행 탐색
		for (int i = 0; i < N; i++) {
			acc = 1;
			go1(i,0,false); //행index, 열index, keep여부
		}

		
		//열 탐색
		for (int i = 0; i < N; i++) {
			acc = 1;
			go2(0,i,false); //행index, 열index, keep여부
		}
		
		System.out.println(result);
	}
	static void go1(int row, int cnt, boolean keep) {
		if(keep==true) {
			if(acc>=L) {
				acc=0;
				go1(row,cnt,false);
				return;
			}
		}
		if(cnt==N-1) {
			if(keep==false) {
				result++;
			}
			return;
		}

		//다음 거 높이 같을 때
		if(map[row][cnt] == map[row][cnt+1]) {
			acc++;
			go1(row, cnt+1, keep);
		}
		
		//다음 거 높이 낮을 때
		if(map[row][cnt] == map[row][cnt+1]+1 && keep == false) {
			acc =1;
			go1(row, cnt+1, true); //일단 이동, 보류라는 의미로 keep=true;
		}
		
		//다음 거 높이 높을 때
		if(map[row][cnt] == map[row][cnt+1]-1) {
			if(acc>=L) {
				acc =1;
				go1(row, cnt+1, keep);
			}
		}
	}
	
	static void go2(int cnt, int col, boolean keep) {
		if(keep==true) {
			if(acc>=L) {
				acc=0;
				go2(cnt,col,false);
				return;
			}
		}
		if(cnt==N-1) {
			if(keep==false) {
				result++;
			}
			return;
		}
		if(map[cnt][col] == map[cnt+1][col]) {
			acc++;
			go2(cnt+1, col, keep);
		}
		if(map[cnt][col] == map[cnt+1][col]+1 && keep == false) {
			acc =1;
			go2(cnt+1, col, true); 
		}
		if(map[cnt][col] == map[cnt+1][col]-1) {
			if(acc>=L) {
				acc =1;
				go2(cnt+1, col, keep);
			}
		}
	}

}