//미완성
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long tot; //총 사람 수
	static Node node[];
	static class Node {
		long X;
		long A;
		public Node(long x, long a) {
			super();
			X = x;
			A = a;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		node = new Node[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			node[i] = new Node(a,b);
			tot += b;
		}
		
		//정렬
		Arrays.sort(node,(a,b) -> {
			if(a.X == b.X) {
				return Long.compare(a.A, b.A);
			}
			return Long.compare(a.X, b.X);
		});
		
		long sum = 0;
		for (Node n : node) {
			sum+= n.A;
			if(sum >= (tot+1)/2) {
				System.out.println(n.X);
				break;
			}
		}
	}

}