package boj_10997;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int [][] result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = new int[4*N -1][4*N -3];
		
		if(N == 1) { //N==1일때 별하나 출력
			System.out.print("*");
			return;
		}else {//중앙 별 세개 찍기
			for (int i = (4*N-1)/2-1; i < (4*N-1)/2+2; i++) {
				result[i][(4*N-4)/2] =1;
			}
		}
		star(N);
		for (int i = 0; i < 4*N -1; i++) {
			if(i ==1) { //두번째줄 별하나찍고 뒤에는 빈칸없도록
				System.out.print("*");
			}else {
				for (int j = 0; j < 4*N -3; j++) {
					//1이면 별, 아니면 빈칸출력
					System.out.print(result[i][j] ==1? "*" :" ");
				}
			}
			System.out.println();
		}

	}
	private static void star(int n) {
		if(n==1) {
			return;
		}
		
		for (int i = 2*(N-n); i < (4*N-1) - 2*(N-n) ; i++) {
			
			if(i == 2*(N-n) || i == 4*N-2 - 2*(N-n)) { //맨위, 맨밑
				for (int j = 2*(N-n); j < 4*N -3 - 2*(N-n); j++) {
					result[i][j] =1;
				}
			}else { //중간
				for (int j = 2*(N-n); j < 4*N -3 - 2*(N-n); j++) {
					result[i][2*(N-n)] =1; //왼쪽 사이드
					if(i != 2*(N-n)+1 ) {
						result[i][4*N-4 - 2*(N-n)] =1; //오른쪽 사이드
					}
					if(i == 2*(N-n)+2) {
						result[i][4*N-5 - 2*(N-n)] =1; //오른쪽 사이드
					}
					
				}
			}
			
		}
		star(n-1); //재귀

	}

}
