package boj_1697;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int []arr = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		
		
		q.offer(N);
		
		while(!q.isEmpty()) {
			int a = q.poll();
			
			if(a == K)
				break;
				
			if(a-1 >= 0 && arr[a-1] == 0) {
				q.offer(a-1);
				arr[a-1] =arr[a]+1;
			}
			if(a+1 <=100000 && arr[a+1] == 0) {
				q.offer(a+1);
				arr[a+1] =arr[a]+1;
			}
			if(2*a <= 100000 && arr[2*a] == 0) {
				q.offer(2*a);
				arr[2*a] =arr[a]+1;
			}

		}
		
		System.out.print(arr[K]);
	
	}
}
