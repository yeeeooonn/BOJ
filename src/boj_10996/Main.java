package boj_10996;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 2*N; i++) {
			
			if(i%2 ==0) {
				for (int j = 0; j < N; j++) {
					if(j%2==0)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}else {
				for (int j = 0; j < N; j++) {
					if(j%2==0)
						System.out.print(" ");
					else
						System.out.print("*");
				}
			}
			System.out.println();
		}
		
	}

}
