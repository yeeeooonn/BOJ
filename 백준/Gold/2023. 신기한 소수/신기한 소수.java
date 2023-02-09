import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] nums;
	static int[] prime = {1,2,3,5,7,9}; //나머지숫자 들어가면 소수가 아님
	static int M = prime.length;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		combi(0,0);
		System.out.println(sb.toString());

	}
	static void combi(int cnt, int start) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) { //0자리수부터 N자리수까지 소수 확인
				int answer = 0; 
				int acc = 0; //누적
				for (int j = 0; j < i; j++) {
					acc += nums[j]*Math.pow(10, i-j);
				}
				answer += acc;
				answer += nums[i];
				
				if(!isPrime(answer)) return; //소수 확인로직
			}
			for (int i = 0; i <N; i++) {
				sb.append(nums[i]);
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < M; i++) {
			nums[cnt] = prime[i];
			combi(cnt+1,start);
			nums[cnt] = 0;
		}
		
	}
	static boolean isPrime(int n) {
		if(n==1) return false;
		for (int i = 2; i <= (int)(Math.sqrt(n)); i++) {
			if(n%i ==0) return false;
		}
		return true;
	}

}
