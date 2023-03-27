import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		sb.append("<");
		while(q.size()>1) {
			for (int i = 0; i < K-1; i++) {
				int temp = q.poll();
				q.offer(temp);
			}
			sb.append(q.poll()).append(", ");
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb.toString());
	}
}