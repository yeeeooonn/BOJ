import java.util.Scanner;
public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = s.nextInt();
		
		for (int i = 0; i < 2*N-1; i++) {
			int jnum = Math.abs(i - (N-1));
			for (int j = 0; j < Math.abs(N-jnum); j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		

	}

}
