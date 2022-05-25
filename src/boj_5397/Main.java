package boj_5397;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			LinkedList<Character> list = new LinkedList<Character>();
			int index = 0;
			
			for(int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				
				if(c =='<') {
					if(index!=0)
						index -= 1;
				} else if(c =='>') {
					if(index != list.size())
						index += 1;
				} else if(c =='-') {
					if(index!=0) {
						list.remove(index-1);
						index -= 1;
					}
				} else {
					list.add(index,c);
					index += 1;
				}
				
			}
			
			for(Character ch : list)
				bw.write(ch);
			
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
