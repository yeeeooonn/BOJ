import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	static int M = 1234567891;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long sum = 0;
		long pow = 1;
		char[] arr = str.toCharArray();
		for(int i = 0; i < L; i++){
			sum += (arr[i] - 'a' + 1) * pow % M;
			pow = pow * 31 % M;
		}
		long hash = sum % M;
		System.out.println(hash);
	}
}