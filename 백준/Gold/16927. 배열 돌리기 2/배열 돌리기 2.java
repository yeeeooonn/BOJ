import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M; //열, 행
	static int R;
	static int[][] arr;
	static int[][] copy;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		copy = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				copy[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		//돌리기 함수
		spin();
		
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				sb.append(copy[j][k]+" ");
			}
			sb.append("\n");
		}
	    System.out.println(sb.toString());                                               
		
	}
	static void spin() {
			
			
		int start = 0;
		int endN = N;
		int endM = M;
		while(start <endN && start<endM) {
			for (int i = 0; i < R % (2*(endN-start)+2*(endM-start)-4); i++) {
				//copy를 arr에 복사
				for (int j = 0; j < copy.length; j++) {
					System.arraycopy(copy[j], 0, arr[j], 0, copy[0].length);
				}
				
				for (int j = start; j < endN-1; j++) {
					copy[j+1][start] = arr[j][start];
				}
				for (int j = start; j < endM-1; j++) {
					copy[endN-1][j+1] = arr[endN-1][j];
				}
				for (int j = endN-1; j > start; j--) {
					copy[j-1][endM-1] = arr[j][endM-1]; 
				}
				for (int j = endM-1; j > start; j--) {
					copy[start][j-1] = arr[start][j];
				}
			}
			start++;
			endN--;
			endM--;
		}
		
	}

}