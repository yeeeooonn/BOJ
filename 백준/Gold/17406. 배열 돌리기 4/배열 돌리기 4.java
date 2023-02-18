import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int K;
	static int r,c,s;
	static int[][] arr;
	static int[][] copy;
	static int[][] copy2;
	static String[] command; //명령 저장 배열
	static int[] seq;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;
	static int sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M]; //기존 배열(수정x)
		copy = new int[N][M]; //최종 돌려진 배열 저장
		copy2 = new int[N][M]; //복사 + 돌리기 
		command = new String[K];
		seq = new int[K];
		visited = new boolean[K];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k = 0; k < K; k++) {
			command[k] = br.readLine();
		}
		
		//모든 경우의 수
		perm(0);
		
		System.out.println(result);
		
	}
	static void perm(int cnt) {
		if(cnt == K) {
			//배열 복사 arr -> copy
			for (int j = 0; j < arr.length; j++) {
				System.arraycopy(arr[j], 0, copy[j], 0, arr[0].length);
			}
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(command[seq[i]]);
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
				
				//배열 복사 copy->copy2
				for (int j = 0; j < copy.length; j++) {
					System.arraycopy(copy[j], 0, copy2[j], 0, copy[0].length);
				}
				spin();

			}
			//열마다 값 비교
			for (int i = 0; i < N; i++) {
				sum = 0;
				for (int j = 0; j < M; j++) {
					sum+= copy[i][j];
				}
				result = Math.min(result, sum);
			}
			return;
		}
		for (int i = 0; i < K; i++) {
			if(visited[i]) continue;
			visited[i]= true;
			seq[cnt] = i;
			perm(cnt+1);
			seq[cnt]=0;
			visited[i]= false;
		}
	}
	static void spin() {
		int startN = r-s-1;
		int startM = c-s-1;
		int endN = r+s-1;
		int endM = c+s-1;
		while(startN <endN && startM<endM) {
			for (int j = startM; j < endM; j++) {
				copy[startN][j+1] = copy2[startN][j];
			}
			for (int j = startN; j < endN; j++) {
				copy[j+1][endM] = copy2[j][endM];
			}
			for (int j = endM; j > startM; j--) {
				copy[endN][j-1] = copy2[endN][j]; 
			}
			for (int j = endN; j > startN; j--) {
				copy[j-1][startM] = copy2[j][startM];
			}
			startN++;
			startM++;
			endN--;
			endM--;
		}
	}
}