import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] weight;
	static boolean[] visited;
	static boolean[][] link;
	static List<Integer> listA;
	static List<Integer> listB;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		weight = new int[N];
		visited = new boolean[N];
		link = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				link[i][Integer.parseInt(st.nextToken())-1] = true;
			}
		}
		result = Integer.MAX_VALUE;
		subset(0,0,0); //cnt,a인구,b인구
		
		System.out.println((result== Integer.MAX_VALUE) ? -1 : result);
		
	}
	static void subset(int cnt, int sumA, int sumB) {
		if(cnt == N) {
			listA = new ArrayList<>();
			listB = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if(visited[i]== true) {
					listA.add(i);
				}
				if(visited[i]== false) {
					listB.add(i);
				}
			}
			if(listA.size()!= 0 && listB.size()!= 0 && isLinked()) {
				result = Math.min(result, Math.abs(sumA-sumB));
			}
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1,sumA+weight[cnt],sumB);
		visited[cnt] = false;
		subset(cnt+1,sumA,sumB+weight[cnt]);
		
	}
	static boolean isLinked() {
		//listA 연결 확인
		boolean[] A = new boolean[listA.size()];
		Queue<Integer> aq = new LinkedList<>();
		aq.offer(listA.get(0));
		A[0] = true;
		while(!aq.isEmpty()) {
			int cur = aq.poll();
			for (int i = 0; i < listA.size(); i++) {
				if(A[i]) continue;
				if(link[cur][listA.get(i)]==true) {
					A[i] = true;
					aq.offer(listA.get(i));
				}
			}
		}
		for (int i = 0; i < A.length; i++) {
			if(A[i] == false) return false;
		}
		
		
		//listB 연결 확인
		boolean[] B = new boolean[listB.size()];
		Queue<Integer> bq = new LinkedList<>();
		bq.offer(listB.get(0));
		B[0] = true;
		while(!bq.isEmpty()) {
			int cur = bq.poll();
			for (int i = 0; i < listB.size(); i++) {
				if(B[i]) continue;
				if(link[cur][listB.get(i)]==true) {
					B[i] = true;
					bq.offer(listB.get(i));
				}
			}
		}
		for (int i = 0; i < B.length; i++) {
			if(B[i] == false) return false;
		}
		return true;
	}

}