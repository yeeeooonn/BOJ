import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] miro = new char[R][C];
		int[][] fire = new int[R][C];
		int[][] exit = new int[R][C];
		Queue<int[]> fireQ = new LinkedList<>();
		Queue<int[]> exitQ = new LinkedList<>();
		int[] bx= {-1,1,0,0};
		int[] by = {0,0,-1,1};
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				miro[i][j] = str.charAt(j);
				fire[i][j] = -1;
				exit[i][j] = -1;
				if(str.charAt(j) == 'F') {
					fireQ.offer(new int[] {i,j});
					fire[i][j] = 0;
				}
				if(str.charAt(j) == 'J') {
					exitQ.offer(new int[] {i,j});
					exit[i][j] = 0;
				}
			}
		}
		
		while(!fireQ.isEmpty()) {
			int[] a =fireQ.poll();
			
			for(int i = 0; i < 4; i++) {
				int ax = a[0]+bx[i];
				int ay = a[1]+by[i];
				
				if(ax<0 || ay<0 || ax >= R || ay >= C) continue;
				if(fire[ax][ay] >= 0 || miro[ax][ay] =='#') continue;
				
				fireQ.offer(new int[] {ax, ay});
				fire[ax][ay] = fire[a[0]][a[1]] +1;

			}
		}
		
		int fireCount = 0;
		
		while(!exitQ.isEmpty()) {
			int[] a = exitQ.poll();
			fireCount++;
			
			for(int i = 0; i < 4; i++) {
				int ax = a[0]+bx[i];
				int ay = a[1]+by[i];
				
				if(ax<0 || ay<0 || ax >= R || ay >= C) {
					System.out.print(exit[a[0]][a[1]] +1);
					return;
				}
				
				if(exit[ax][ay] >= 0 ||  miro[ax][ay] == '#') continue;
				if(fire[ax][ay] != -1 && fire[ax][ay] <= exit[a[0]][a[1]] +1) continue;

				
				exitQ.offer(new int[] {ax, ay});
				exit[ax][ay] = exit[a[0]][a[1]] +1;

			}
			
		}
		System.out.print("IMPOSSIBLE");
	}
}
