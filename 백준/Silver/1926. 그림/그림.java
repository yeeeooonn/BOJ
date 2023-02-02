import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int [][] paper;
	static boolean [][] check;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int max, num; //가장 넓은 그림 넓이, 그림 수
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		check = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(paper[i][j] == 0 || check[i][j]) continue;
				num++;
				
				check[i][j] = true;
				q.offer(new int []{i,j});
				int count = 0; // 그림  수
				
				while(!q.isEmpty()) {
					count++;
					int a [] = q.poll();
					
					for (int d = 0; d < 4; d++) {
						int ar = a[0] + dr[d];
						int ac = a[1] + dc[d];
						if(!check(ar,ac)) continue;
						if(check[ar][ac] || paper[ar][ac] !=1) continue;
						
						check[ar][ac] = true;
						q.offer(new int [] {ar,ac});
					}
					
				}
				if(max < count)
					max = count;
				
			}
		}
		System.out.println(num);
		System.out.println(max);

	}
	public static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<n && c<m;
	}

}
