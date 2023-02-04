import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		
		B+=C;
		
		if(B >= 60) {
			int a1 = B/60;
			A+= a1;
			B = B - 60*a1;
		}
		if(A>=24)
			A = A%24;
		
		System.out.println(A+" "+B);

	}

}
