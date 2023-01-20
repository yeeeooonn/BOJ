import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i-1; j++) {
				sb.append(" ");
			}
			for (int k = 0; k < 2*i+1; k++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
