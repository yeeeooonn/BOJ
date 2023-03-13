import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer>[] list;
	static int[] parent;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		parent = new int[N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);
		
		for (int i = 2; i < N+1; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void dfs(int index) {
		visited[index] = true;
		for (int i : list[index]) {
			if(!visited[i]) {
				parent[i] = index;
				dfs(i);
			}
		}
		
	}

}