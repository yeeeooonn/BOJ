package boj_10992;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			//마지막줄
			if(i == N) {
				for (int j = 0; j < 2*i -1; j++) {
					System.out.print("*");
				}
			break;
			}
			
			//첫 빈칸
			for (int j = 0; j < N-i; j++) {
				System.out.print(" ");
			}
			
			//첫 별
			System.out.print("*");
			
			//중간 빈칸
			for (int j = 0; j < 2*(i-1)-1; j++) {
				System.out.print(" ");
			}
			
			//마지막별, i=1일떈 출력x
			if(i!=1)
				System.out.print("*");
			
			
			System.out.println();
		}

	}

}
