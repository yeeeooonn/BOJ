package boj_1406;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		Stack<String> leftSt = new Stack<String>();
		Stack<String> rightSt = new Stack<String>();
		
		String[] arr = str.split("");
		for(int i = 0; i<arr.length;i++) //왼쪽스택에 초기 문자열 넣어줌
			leftSt.push(arr[i]);
		
		for(int i = 0; i<N; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
			
			if(c =='L') {
				if(!leftSt.isEmpty())
					rightSt.push(leftSt.pop());
			} else if(c =='D') {
				if(!rightSt.isEmpty())
					leftSt.push(rightSt.pop());
			} else if(c == 'B') {
				if(!leftSt.isEmpty())
					leftSt.pop();
			}else if(c == 'P') {
				leftSt.push(String.valueOf(command.charAt(2)));
			}
		}
		
		while(!leftSt.isEmpty())
			rightSt.push(leftSt.pop());
		
		while(!rightSt.isEmpty())
			bw.write(rightSt.pop());
		
		br.close();
		bw.flush();
		bw.close();
	}
}
