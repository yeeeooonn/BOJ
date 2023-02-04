package boj_1874;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		
		int start = 0;
		
		for(int i = 0; i < N; i ++) {
			int a = Integer.parseInt(br.readLine());
			
			if(start < a) {
				for(int j = start+1; j <= a; j ++) {
					s.push(j);
					sb.append('+').append('\n');
					start +=1;
				}
				
			}else if (s.peek()!=a) {
				System.out.println("NO");
				return;
			}
			
			s.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}
}
