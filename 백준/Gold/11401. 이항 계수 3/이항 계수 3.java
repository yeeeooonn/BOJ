import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, P=1000000007;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		long r = nCr(N,K);
		System.out.println((r)%P);
	}
	
	static long fact(long n) {
		long re=1L;
		for (int i = 1; i <= n; i++) {
			re*=i;
			re%=P;
		}
		return re%P;
	}
	static long nCr(long n, long k) {
		long re=1L;
		re*=fact(n);
		re%=P;
		re*=power(fact(n-k),P-2);
		re%=P;
		re*=power(fact(k),P-2);
		re%=P;
		return re;
	}
	static long power(long x, long y) {
		if(y == 0) return 1;
		
		long tmp = power(x,y/2);
		long val = (tmp*tmp)% P;
		
		if(y%2 == 0) return val;
		else return (val * x) % P;
	}
}