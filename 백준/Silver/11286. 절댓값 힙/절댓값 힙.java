import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static class P implements Comparable<P>{
		int x;

		public P(int x) {
			this.x = x;
		}
		@Override
		public int compareTo(P p) { //절댓값기준 정렬, 같다면 작은수부터 정렬
			int i1 = Math.abs(this.x);
			int i2 = Math.abs(p.x);
			if(i1 == i2)
				return Integer.compare(this.x, p.x);
			return Integer.compare(i1, i2);
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<P> q = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(br.readLine());
			
			if(cur == 0) {
				if(q.isEmpty()) { //큐가 비어있으면  0출력
					sb.append("0 \n");
				}else {
					P top = q.poll();
					sb.append(top.x+"\n");
				}
			}else {
				q.offer(new P(cur));
			}
		}
		System.out.println(sb.toString());
	}
}