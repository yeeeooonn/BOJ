import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answerR,answerC; //답변 위치
	static int[][] omok;
	static int result;
	static int[] dr = {-1,0,1,1}; //오위, 오, 왼아, 아
	static int[] dc = {1,1,1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		omok = new int[19][19];
		for (int i = 0; i <19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				omok[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i <19; i++) {
			for (int j = 0; j < 19; j++) {
				if(omok[i][j] ==1 || omok[i][j] ==2)
					move(i,j,omok[i][j]);
			}
		}
		
		System.out.println(result);
		if(result != 0) System.out.println(answerR+" "+answerC);
	}
	static void move(int r, int c, int color) {
		
		for (int d = 0; d < 4; d++) {
			int count = 1;
			int nr = r + dr[d];
			int nc = c + dc[d];

			if(!check(nr,nc) || omok[nr][nc]!=color) continue; //범위를 벗어났거나 같은색이 아닐때
			count++;
			
			while(true) {
				nr = nr + dr[d];
				nc = nc + dc[d];
				if(!check(nr,nc) || omok[nr][nc]!=color) break;
				count++;
			}
			if(count==5) {
				int cr = r - dr[d];
				int cc = c - dc[d];
				if(check(cr,cc)) {
					if(omok[cr][cc]==color) break;
				}
				result = color;
				answerR = r+1;
				answerC = c+1;
			}
		}
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<19 && nc<19;
	}
}