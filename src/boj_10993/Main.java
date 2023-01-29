package boj_10993;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int h = height(N);
		int w = weight(N);
		
		result = new int[h][w];
		
		if(N%2 ==0) {
			star(N,0,0);
		}else {
			star(N,h-1,0);
		}

		for (int i = 0; i < h; i++) {//출력
			if(N%2==0) {//짝수일 때
				for (int j = 0; j < w-i; j++) {
					sb.append(result[i][j]==1? "*" :" ");
					
				}
			}else {//홀수일 때
				for (int j = 0; j < h+i; j++) {
					sb.append(result[i][j]==1? "*" :" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void star(int n, int startRow, int startCol) {
		int row = height(n);
		int col = weight(n);
		draw(n, startRow, startCol, row, col);
		
		if(n ==1)
			return;
		
		
		if(n %2==0) { //짝수일 때
			star(n-1,startRow+row/2,startCol+row/2+1);
		}else { //홀수일 때
			star(n-1,startRow-row/2,startCol+row/2+1);
		}
		
	}
	
	private static void draw(int n, int startRow, int startCol, int row, int col) {
		if(n %2 == 0) {//짝수일 때 -> 역 삼각형
			for (int i = 0; i < row; i++) {
				if(i==0) { // 맨 위
					for (int j = 0; j < col; j++) {
						result[startRow][startCol+j] =1;
					}
				}else if(i == row-1){ //맨 아래
					result[startRow+i][startCol+row-1] =1;
				}else { //중간
					result[startRow+i][startCol+i] =1;
					result[startRow+i][startCol+col-i-1] =1;
					
				}
			}
			
		}else {//홀수일 때 -> 제대로된 삼각형
			for (int i = 0; i < row; i++) {
				if(i == 0) { //맨 아래
					for (int j = 0; j < col; j++) {
						result[startRow][startCol +j] =1;
					}
				}else if(i==row-1) { //맨 위
					result[startRow-i][startCol+row-1] =1;
				}else {
					result[startRow-i][startCol+i]=1;
					result[startRow-i][startCol+col-i-1]=1;
				}
			}
			
		}
		
	}
	private static int height(int n) { //세로 배열 수
		if(n==1)
			return 1;
		return 2*height(n-1)+1;
	}
	private static int weight(int n) { //가로 배열 수
		if(n==1)
			return 1;
		return 2*weight(n-1)+3;
	}

}