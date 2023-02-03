import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int a = 0;
		
		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			switch(input[0]) {
				case("push") :
					q.offer(Integer.parseInt(input[1]));
					a = Integer.parseInt(input[1]);
					break;
				case("pop"):
					if(!q.isEmpty())
						bw.write(q.poll()+"\n");
					else
						bw.write("-1\n");
					break;
				case("size"):
					bw.write(q.size()+"\n");
					break;
				case("empty"):
					if(!q.isEmpty())
						bw.write("0\n");
					else
						bw.write("1\n");
					break;
				case("front"):
					if(!q.isEmpty())
						bw.write(q.peek()+"\n");
					else
						bw.write("-1\n");
					break;
				case("back"):
					if(!q.isEmpty())
						bw.write(a+"\n");
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