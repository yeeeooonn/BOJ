import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		while(N != 0) {
			sb.append("long ");
			N-=4;
		}
		sb.append("int ");
		System.out.println(sb.toString());
	}

}