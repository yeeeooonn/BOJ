import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int T;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		boolean prime[] = new boolean[10001];
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i])
				continue;
			for (int j = i*i; j < prime.length; j+=i) {
				prime[j] = true;
			}
		}
		
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			for (int j = n/2; j >= 2; j--) {
				if(!prime[j] && !prime[n-j]) { //둘다 소수면
					sb.append(j+" "+(n-j)+"\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}

}
