import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		if(first==1) {
			for (int i = 1; i < 8; i++) {
				if(i+1 != Integer.parseInt(st.nextToken())) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("ascending");
			return;
		}
		if(first==8) {
			for (int i = 6; i >= 0; i--) {
				if(i+1 != Integer.parseInt(st.nextToken())) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("descending");
			return;
		}
		System.out.println("mixed");
	}

}