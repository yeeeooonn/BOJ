import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int X;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		int price[] = new int[N];
		int num[] = new int[N];
		int tot = 0;
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			price[i] = Integer.parseInt(st.nextToken());
			num[i] = Integer.parseInt(st.nextToken());
			tot += price[i]*num[i];
		}
		
		System.out.println((tot==X)? "Yes":"No" );

	}

}
