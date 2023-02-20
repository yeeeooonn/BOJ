import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		tree(0,0,N);
		System.out.println(sb.toString());
		
		
	}
	static void tree(int r, int c, int n) {
		if(isAll(r,c,n)) {
			sb.append(map[r][c]);
			return;
		}
		sb.append("(");
		tree(r,c,n/2);
		tree(r,c+n/2,n/2);
		tree(r+n/2,c,n/2);
		tree(r+n/2,c+n/2,n/2);
		sb.append(")");
	}
	static boolean isAll(int rr, int cc, int nn) {
		int first = map[rr][cc];
		for (int i = rr; i < rr+nn; i++) {
			for (int j = cc; j < cc+nn; j++) {
				if(map[i][j] != first)
					return false;
			}
		}
		return true;
	}

}