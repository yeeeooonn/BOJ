import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M; //행,열
	static int R;
	static int maxNM;
	static int[][] arr;
	static int[][] copy;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		maxNM = Math.max(N, M);
		
		arr = new int[maxNM][maxNM];
		copy = new int[maxNM][maxNM];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			
			//복사
			for (int j = 0; j < arr.length; j++) {
				System.arraycopy(arr[j], 0, copy[j], 0, arr[0].length);
			}
			int command = Integer.parseInt(st.nextToken());
			if(command==1) move1();
			if(command==2) move2();
			if(command==3) move3();
			if(command==4) move4();
			if(command==5) move5();
			if(command==6) move6();
		}
		//출력
		for (int j = 0; j < N; j++) {
			for (int j2 = 0; j2 < M; j2++) {
				sb.append(arr[j][j2]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static void move6() {
		// 그룹 반시계방향 회전
		int halfN = N/2;
		int halfM = M/2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//1구역 -> 4구역
				if(i< halfN && j<(halfM)) {
					arr[i+halfN][j] = copy[i][j];
				}
				//2구역 -> 1구역
				if(i<halfN && j>=halfM) {
					arr[i][j-halfM] = copy[i][j];
				}
				//3구역 -> 2구역
				if(i>=halfN && j>=halfM) {
					arr[i-halfN][j] = copy[i][j];
				}
				//4구역 -> 3구역
				if(i>=halfN && j<halfM) {
					arr[i][j+halfM] = copy[i][j];
				}
			}
		}
	}
	static void move5() {
		// 그룹 시계방향 회전
		int halfN = N/2;
		int halfM = M/2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//1구역 -> 2구역
				if(i< halfN && j<(halfM)) {
					arr[i][j+halfM] = copy[i][j];
				}
				//2구역 -> 3구역
				if(i<halfN && j>=halfM) {
					arr[i+halfN][j] = copy[i][j];
				}
				//3구역 -> 4구역
				if(i>=halfN && j>=halfM) {
					arr[i][j-halfM] = copy[i][j];
				}
				//4구역 -> 1구역
				if(i>=halfN && j<halfM) {
					arr[i-halfN][j] = copy[i][j];
				}
			}
		}	
	}
	static void move4() {
		// 왼쪽으로 90도 회전
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[M-1-j][i] = copy[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
	}
	static void move3() {
		// 오른쪽으로 90도 회전
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[j][N-1-i] = copy[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
	}
	static void move2() {
		//좌우반전
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = copy[i][M-1-j];
			}
		}
	}
	static void move1() {
		//상하반전
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = copy[N-1-i][j];
			}
		}
	}
}