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
		if(flag) {
			return;
		}
		if(cnt == size) {
			if(!flag) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						sb.append(map[i][j]);
					}
					sb.append("\n");
				}
				System.out.println(sb.toString());
				flag = true;
			}
			return;
		}
		int cur[] = list.get(cnt);
		int i = cur[0];
		int j = cur[1];
		
		for (int k = 1; k < 10; k++) {
			checkNum = new boolean[10]; //1~9
			checkRow(i);
			checkCol(j);
			checkRange(i,j);
			if(checkNum[k]) continue;
			map[i][j] = k;
			d(cnt+1);
			map[i][j] = 0;
		}
		return;
	}
	static void checkRange(int r, int c) {
		if(r<3 && c<3) {
			checkRec(0,0);
		}
		if(r<3 && c<6&& c>=3) {
			checkRec(0,3);
		}
		if(r<3 && c>=6) {
			checkRec(0,6);
		}
		if(r>=3 && r<6 && c<3) {
			checkRec(3,0);
		}
		if(r>=3 && r<6 && c<6&& c>=3) {
			checkRec(3,3);
		}
		if(r>=3 && r<6 && c>=6) {
			checkRec(3,6);
		}
		if(r>=6 && c<3) {
			checkRec(6,0);
		}
		if(r>=6 && c<6&& c>=3) {
			checkRec(6,3);
		}
		if(r>=6 && c>=6) {
			checkRec(6,6);
		}
	}
	static void checkRec(int r, int c) {
		for (int i = r; i < r+3; i++) {
			for (int j = c; j < c+3; j++) {
				if(map[i][j] != 0) {
					checkNum[map[i][j]] = true;
				}
			}
		}
		
	}
	static void checkCol(int c) {
		for (int i = 0; i < 9; i++) {
			if(map[i][c] != 0) {
				checkNum[map[i][c]] = true;
			}
		}
		
	}
	static void checkRow(int r) {
		for (int i = 0; i < 9; i++) {
			if(map[r][i] != 0) {
				checkNum[map[r][i]] = true;
			}
		}
		
	}

}