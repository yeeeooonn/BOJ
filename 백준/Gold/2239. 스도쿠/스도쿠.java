import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[] checkNum;
	static int size;
	static List<int[]> list;
	static boolean flag;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		list = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
				if(map[i][j]== 0) {
					//리스트 추가
					list.add(new int[] {i,j});
				}
			}
		}
		
		size= list.size();
		
		d(0);

	}
	static void d(int cnt) {
		
		if(cnt == size) {
			
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						sb.append(map[i][j]);
					}
					sb.append("\n");
				}
				System.out.println(sb.toString());
				
			
			System.exit(0);
		}
		int cur[] = list.get(cnt);
		int i = cur[0];
		int j = cur[1];
		
		
		boolean[] checkB = new boolean[10]; //1~9
		checkRow(i,checkB);
		checkCol(j,checkB);
		checkRange(i,j,checkB);
		for (int k = 1; k < 10; k++) {
			
			if(checkB[k]) continue;
			map[i][j] = k;
			d(cnt+1);
			map[i][j] = 0;
		}
		return;
	}
	static void checkRange(int r, int c, boolean[] checkB) {
		checkRec(r/3*3,c/3*3, checkB);
	}
	static void checkRec(int r, int c, boolean[] checkB) {
		for (int i = r; i < r+3; i++) {
			for (int j = c; j < c+3; j++) {
				if(map[i][j] != 0) {
					checkB[map[i][j]] = true;
				}
			}
		}
		
	}
	static void checkCol(int c, boolean[] checkB) {
		for (int i = 0; i < 9; i++) {
			if(map[i][c] != 0) {
				checkB[map[i][c]] = true;
			}
		}
		
	}
	static void checkRow(int r, boolean[] checkB) {
		for (int i = 0; i < 9; i++) {
			if(map[r][i] != 0) {
				checkB[map[r][i]] = true;
			}
		}
		
	}

}