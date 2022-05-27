package boj_10866;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> d = new ArrayDeque<>();
		
		for(int i = 0; i <N; i++) {
			String input[] = br.readLine().split(" ");
			
			switch(input[0]) {
				case("push_front"):
					d.offerFirst(Integer.parseInt(input[1]));
					break;
				case("push_back"):
					d.offerLast(Integer.parseInt(input[1]));
					break;
				case("pop_front"):
					if(!d.isEmpty())
						bw.write(d.pollFirst()+"\n");
					else
						bw.write("-1\n");
					break;
				case("pop_back"):
					if(!d.isEmpty())
						bw.write(d.pollLast()+"\n");
					else
						bw.write("-1\n");
					break;
				case("size"):
					bw.write(d.size()+"\n");
					break;
				case("empty"):
					if(!d.isEmpty())
						bw.write("0\n");
					else
						bw.write("1\n");
					break;
				case("front"):
					if(!d.isEmpty())
						bw.write(d.peekFirst()+"\n");
					else
						bw.write("-1\n");
					break;
				case("back"):
					if(!d.isEmpty())
						bw.write(d.peekLast()+"\n");
					else
						bw.write("-1\n");
					break;
				default:
					break;
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}