import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
 
		System.out.println(c(N, K));
		
	}
	
	static int c(int n, int k) {
		
		if(n == k || k == 0) {
			return 1;
		}
 
		return c(n - 1, k - 1) + c(n - 1, k);
	}
}