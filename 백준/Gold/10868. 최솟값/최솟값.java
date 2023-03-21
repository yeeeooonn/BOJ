import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static long[] nums;
	static long[] tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new long[N+1];
		tree = new long[N*4];
		for (int i = 1; i < N+1; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		
		seg(1,1,N);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(find(a,b,1,1,N)).append("\n");
		}
		System.out.println(sb.toString());

	}
	static long find(int l, int r, int node, int s, int e) {
		if(l > e || r < s) { //범위 밖
			return Long.MAX_VALUE;
		}
		if(l <= s && e <= r) { //범위 안
			return tree[node];
		}
		
		int mid = (s+e)/2;
		long left = find(l,r,node*2,s,mid);
		long right = find(l,r,node*2+1,mid+1,e);
		return Math.min(left, right);
	}
	static long seg(int node, int s, int e) {
		if(s == e) {
			return tree[node] = nums[s];
		}
		int mid = (s+e)/2;
		long left = seg(node*2,s,mid);
		long right = seg(node*2+1,mid+1,e);
		return tree[node] = Math.min(left, right);
	}

}