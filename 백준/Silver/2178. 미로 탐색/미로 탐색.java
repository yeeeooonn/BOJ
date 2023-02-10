import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		int[][] dis = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
				dis[i][j] = -1;
			}
		}
		
		q.offer(new int[] {0,0});
		dis[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] a =q.poll();
			for(int i = 0; i<4; i++) {
				int ax = a[0]+dx[i];
				int ay = a[1]+dy[i];
				
				if(ax<0 || ay<0|| ax >= N || ay>=M) continue;
				if(arr[ax][ay] == 0 || dis[ax][ay] >=0) continue;
				
				q.offer(new int[] {ax,ay});
				dis[ax][ay] = dis[a[0]][a[1]]+1;
			}
		}
		
		bw.write(dis[N-1][M-1]+1+"");
		br.close();
		bw.flush();
		bw.close();
	}
}
