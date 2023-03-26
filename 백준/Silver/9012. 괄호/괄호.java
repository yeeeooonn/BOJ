import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(') {
					count++;
				}
				if(str.charAt(j) == ')') {
					count--;
				}
				if(count < 0) {
					break;
				}
			}
			
			if(count == 0) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}	
		}
		System.out.println(sb.toString());

	}

}