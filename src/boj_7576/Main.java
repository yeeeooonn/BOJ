package boj_7576;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int[][] dis = new int[N][M]; //°Å¸®
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		
		Queue<int[]> q = new LinkedList<>();
		
		
		for(int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					q.offer(new int[] {i,j});
				}
				if(arr[i][j] == 0) {
					dis[i][j] = -1;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			
			for(int i = 0; i<4; i++) {
				int ax = a[0]+dx[i];
				int ay = a[1]+dy[i];
				
				if(ax<0 || ay <0 || ax>=N || ay >=M) continue;
				if(dis[ax][ay] >=0) continue;
				
				dis[ax][ay] = dis[a[0]][a[1]] +1;
				q.offer(new int[] {ax,ay});
			}
		}

		int max = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(dis[i][j] == -1) {
					System.out.println(-1);
					return;
				}
				if(max < dis[i][j])
					max = dis[i][j];
			}
		}

		System.out.println(max);

	}
}

