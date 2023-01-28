package boj_10994;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][]result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		result = new int[4*(N-1)+1][4*(N-1)+1];
		
		star(N);
		
		for (int i = 0; i < 4*(N-1)+1; i++) {
			for (int j = 0; j < 4*(N-1)+1; j++) {
				System.out.print(result[i][j]==1? "*" : " ");
			}
			System.out.println();
		}

	}
	private static void star(int n) {
			
		for (int i = 2*(N-n); i < 4*(N-1)+1 - 2*(N-n); i++) {
			for (int j = 2*(N-n); j < 4*(N-1)+1 - 2*(N-n); j++) {
				
				if(i == 2*(N-n) || i == 4*(N-1)- 2*(N-n)) {
					result[i][j] =1;
				}else {
					result[i][2*(N-n)] =1;
					result[i][4*(N-1) - 2*(N-n)] =1;
				}
			}
			
		}
		if(n == 1)
			return;
		star(n-1);
		
	}

}
