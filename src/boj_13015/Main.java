package boj_13015;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 2*N-1; i++) {
			
			if(i == 0 || i == 2*N-2) { //첫줄과 마지막줄
				for (int j = 0; j < N; j++) {
					System.out.print("*");
				}
				for (int j = 0; j < 2*(N-1)-1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < N; j++) {
					System.out.print("*");
				}
				
			}else { //중간줄
				int b1 = Math.abs((N-1) -i);
				//첫 빈칸
				for (int j = 0; j < (N-1)-b1; j++) {
					System.out.print(" ");
				}
				//첫 별
				System.out.print("*");
				//두번째 빈칸
				for (int j = 0; j < N-2; j++) {
					System.out.print(" ");
				}
				//두번째 별
				System.out.print("*");
				//세번째 빈칸
				if(!(i==N-1)) {
					for (int j = 0; j < 2*(b1-1)+1; j++) {
						System.out.print(" ");
					}
				}
				//세번째 별
				if(!(i==N-1)) {
					System.out.print("*");
				}
				//네번째 빈칸
				for (int j = 0; j < N-2; j++) {
					System.out.print(" ");
				}
				//네번째 별
				System.out.print("*");
				
			}
			System.out.println();
		}

	}

}
