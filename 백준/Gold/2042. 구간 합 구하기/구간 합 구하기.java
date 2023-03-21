import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static long[] nums;
	static long[] tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		nums = new long[N+1];
		tree = new long[4*N];
		
		for (int i = 1; i < N+1; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		
		set(1,1,N);
		
		
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a == 1) {
				nums[b] = c;
				update(b,c,1,1,N);
			}
			if(a == 2) {
				sb.append(find(b,c,1,1,N)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static long update(int index, long v, int node, int s, int e) {
		if(index < s || e < index) {
			return tree[node];
		}
		if(s == e) {
			return tree[node] = v;
		}
		
		int mid = (s+e)/2;
		long left = update(index,v,node*2,s,mid);
		long right = update(index,v,node*2+1,mid+1,e);
		
		return tree[node] = (left+right);
	}

	static long find(int left, long right, int node, int s, int e) {
		if(left>e || right <s) { //범위 해당 X
			return 0;
		}
		
		if(left<=s && e<=right) { //범위 안에 있는 경우
			return tree[node];
		}
		int mid = (s+e)/2;
		long l = find(left,right,node*2,s,mid);
		long r = find(left,right,node*2+1,mid+1,e);
		return (l+r);
	}

	static long set(int node, int s, int e) {
		if(s == e) {
			return tree[node] = nums[s];
		}
		int mid = (s+e)/2;
		long left = set(node*2,s,mid);
		long right = set(node*2+1,mid+1,e);
		return tree[node] = left+right;
		
	}

}