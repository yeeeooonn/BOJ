package boj_1021;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> d = new LinkedList<>();
		for(int i = 1; i<=N; i++)
			d.offer(i);
		
		st = new StringTokenizer(br.readLine()," ");
		
		int mid = 0;
		int count = 0;
		
		for(int i = 0; i < M; i ++) {
			int a = Integer.parseInt(st.nextToken());
			int idx = d.indexOf(a);
			
			if(d.size()%2 == 0)
				mid = d.size()/2-1;
			else
				mid = d.size()/2;
						
			if(mid < d.indexOf(a)) { //중간지점보다 원소의 위치가 뒤에 있는 경우
				int num = d.size()-d.indexOf(a);
				for(int j = 0; j < num ; j ++) {
					d.offerFirst(d.pollLast()); //3번연산
					count+=1;
				}
			} else {
				int num = d.indexOf(a);
				for(int j = 0 ; j <num; j ++) {
					d.offerLast(d.pollFirst()); //2번연산
					count +=1;
				}
			}
			d.pollFirst(); //1번연산
		}
		bw.write(count+"");
		br.close();
		bw.flush();
		bw.close();
	}
}

