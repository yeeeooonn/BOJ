import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//List 사용
public class Main {
	static int N,M;
	static List<Integer>[] lists;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		lists = new ArrayList[N];
		visited = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			if(lists[s] == null) lists[s] = new ArrayList<>();
			if(lists[e] == null) lists[e] = new ArrayList<>();
			lists[s].add(e);
			lists[e].add(s);
		}
		bfs(0);
		result();
	}
	static void result() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(visited[i]) cnt++;
		}
		System.out.println(cnt-1);
	}
	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(s);
		visited[s] = true;
		while(!q.isEmpty()) {
			int start = q.poll();
			for (int e : lists[start]) {
				if(visited[e]) continue;
				q.offer(e);
				visited[e] = true;
			}
		}
	}
}