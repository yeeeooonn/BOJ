package boj_10991;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			
			//첫 빈칸
			for (int j = 0; j < N-i; j++) {
				System.out.print(" ");
			}
			
			//별
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			
			System.out.println();
		}

	}

}
