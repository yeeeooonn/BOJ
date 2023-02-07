import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] paper;
	static int wcount,bcount; //하얀색종이 카운트, 파란색 종이 카운트
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		d(0,0,N); //r,c,넓이
		System.out.println(wcount);
		System.out.println(bcount);
	}
	public static void d(int r, int c, int n) {
		if(n==1 || check(r,c,n)) {//탈출
			if(paper[r][c] ==1)
				bcount++;
			else
				wcount++;
		}
		//전체 같은지 체크로직
		if(!check(r,c,n)) {
			d(r,c,n/2);
			d(r,c+n/2,n/2);
			d(r+n/2,c,n/2);
			d(r+n/2,c+n/2,n/2);		
		}	
		
	}
	public static boolean check(int r, int c, int n) {
		int a = paper[r][c];
		for (int i = r; i <r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if(a!= paper[i][j])
					return false;
			}
		}
		return true;
	}
}
