package boj_2493;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> s = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 1; i <= N; i ++) {
			int a = Integer.parseInt(st.nextToken());
			
			while(!s.isEmpty()) {
				if(s.peek()[1] >= a) {
					bw.write(s.peek()[0] + " ");
					break;
				}
				s.pop();
			}
			
			if(s.isEmpty())
				bw.write("0 ");
			
			s.push(new int[] {i, a});

		}
		br.close();
		bw.flush();
		bw.close();
	}
}
