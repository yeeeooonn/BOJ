import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N = 5;
	public static void main(String[] args) throws IOException{
		int num[] = new int[5];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum+= num[i];
		}
		System.out.println(sum/5);
		System.out.println(num[2]);

	}

}
