import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] points;
	static int[][] result; // 0: 이전거 방문x, 1:이전거 방문
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		points = new int[N];
		result = new int[N][2];
		for (int i = 0; i < N; i++) {
			points[i] = Integer.parseInt(br.readLine());
		}
		
		if(N==1) {
			System.out.println(points[0]);
			return;
		}
		
		result[N-1][0] = points[N-1];
		for (int i = N-2; i >=0; i--) {
			if(i != N-2)
				result[i][0] = Math.max(result[i+2][0], result[i+2][1])+ points[i];
			result[i][1] = result[i+1][0] + points[i]; //true 면 이전거 false를 가져옴
		}

		int result0 = Math.max(result[0][0], result[0][1]);
		int result1 = Math.max(result[1][0], result[1][1]);
		System.out.println(Math.max(result0, result1));
	}
}