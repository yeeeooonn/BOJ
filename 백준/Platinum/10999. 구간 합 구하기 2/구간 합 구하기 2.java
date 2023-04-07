import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static long[] nums;
	static long[] tree;
	static long[] lazy;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new long[N+1];
		tree = new long[4*N];	
		lazy = new long[4*N];
		
		for (int i = 1; i <= N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		
		init(1,1,N); //노드번호, 시작인덱스, 끝 인덱스
		
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1) {
				//업데이트
				long d = Long.parseLong(st.nextToken());
				update(b,c,1,1,N,d); //구간시작인덱스, 구간끝인덱스, 노드번호, 시작인덱스, 끝인덱스, 변경 값
			}
			if(a == 2) {
				//출력
				sb.append(find(b,c,1,1,N)).append("\n"); //구간시작인덱스, 구간끝인덱스, 노드번호, 시작인덱스, 끝인덱스
			}
		}
		System.out.println(sb.toString());
		
	}
	static void update(int l, int r, int node, int s, int e, long d) {
		propagate(s,e,node); //해당 노드에 갱신할 값이 있다면 갱신
		if(r < s || e < l) return;
		if(l<=s && e<=r) {
			//범위에 속할경우 업데이트 lazy값 갱신
			lazy[node] = d;
			propagate(s,e,node);
			return;
		}
		
		int mid = (s+e)/2;
		update(l,r,node*2,s,mid,d);
		update(l,r,node*2+1,mid+1,e,d);
		tree[node] = tree[node*2] + tree[node*2+1];
	}
	static void propagate(int s, int e, int node) {
		if(lazy[node]!= 0) {
			if(s != e) {
				//리프노드가 아니면 lazy 물려줌(자식은 나중에 계산)
				lazy[node*2] += lazy[node];
				lazy[node*2+1] += lazy[node];	
			}
			//tree[node] = 업데이트 값 + 해당 자식노드 개수
			tree[node] += lazy[node] * (e-s+1);
			lazy[node] = 0; //반영 했으면 0으로 바꿔줌
		}
		
	}
	static long find(int l, int r, int node, int s, int e) {
		propagate(s, e, node); //업데이트
		if(r < s || e < l) {
			return 0;
		}
		if(l<=s && e<=r) {
			return tree[node];
		}
		
		int mid = (s+e)/2;
		long left = find(l,r,node*2,s,mid);
		long right = find(l,r,node*2+1,mid+1,e);
		
		return left+right;
	}
	static long init(int node, int s, int e) {
		if(s == e) {
			return tree[node] = nums[s];
		}
		int mid = (s+e)/2;
		long left = init(node*2,s,mid);
		long right = init(node*2+1,mid+1,e);
		return tree[node] = left+right;
		
	}

}