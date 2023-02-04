package boj_10773;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		
		for(int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				s.pop();
			}else {
				s.push(num);
			}
		}
		
		int sum = 0;
		
		while(!s.isEmpty()) 
			sum += s.pop();
		
		bw.write(sum+"");
		br.close();
		bw.flush();
		bw.close();
		
		
	}
}
