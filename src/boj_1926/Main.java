package boj_1926;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		boolean[][] check = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		int num = 0; //그림의 수
		int max = 0; //그림의 최댓값
		
		for(int i = 0; i< n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j< m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0; i< n; i++) {
			for(int j = 0; j< m; j++) {
				//색칠이 안된부분 이거나 이미 방문했으면 제외
				if(arr[i][j] ==0 || check[i][j] ) continue;
				num++;
				
				check[i][j] = true;
				q.offer(new int[] {i,j});
				int count = 0;
				
				while(!q.isEmpty()) {
					count++; //pop이 일어날 때 마다 카운트(넓이)증가
					int[] a = q.poll();
					
					for(int d = 0; d <4; d++) {
						//상하좌우 좌표값을 담아줌
						int nx = a[0]+dx[d];
						int ny = a[1]+dy[d];
						//범위 내에 들어오는지 확인 후 범위 내 값이 아니면 걸러내기
						if(nx<0 || ny<0 || nx>= n || ny >= m) continue;
						//이미 방문했거나 색칠이 안된 부분 걸러내기
						if(check[nx][ny] || arr[nx][ny] != 1) continue;
						
						check[nx][ny] =true;
						q.offer(new int[] {nx, ny});
					}
				}
				
				if(max < count)
					max = count;
			}	
		}
		bw.write(num+"\n");
		bw.write(max+"");
		br.close();
		bw.flush();
		bw.close();
	}
}
