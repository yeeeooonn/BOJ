import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int r,c;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

//		System.out.println(1<<N);
//		System.out.println(1<<N * 1<<N);
		d(1<<N,r,c,1<<N * 1<<N);
		
	}
	
	public static void d(int n, int r, int c, int max) {
		int rmax = n*n/4;
		if(n == 2) {
			if(n/2 > r && n/2 > c) {//왼 위
				System.out.println(max-4);
				return;
			}else if(n/2 > r && n/2 <= c) { //오른 위
				System.out.println(max-3);
				return;
			}else if(n/2 <= r && n/2 > c) { //왼 아래
				System.out.println(max-2);
				return;
			}else if(n/2 <= r && n/2 <= c) { //오른 아래
				System.out.println(max-1);
				return;
			}
		}
		
		if(n/2 > r && n/2 > c) {//왼 위
			d(n/2, r, c, max-rmax*3);
		}else if(n/2 > r && n/2 <= c) { //오른 위
			d(n/2, r, c-n/2, max-rmax*2);
		}else if(n/2 <= r && n/2 > c) { //왼 아래
			d(n/2, r - n/2, c, max-rmax);
		}else if(n/2 <= r && n/2 <= c) { //오른 아래
			d(n/2, r- n/2, c- n/2, max);
		}
	}

}
