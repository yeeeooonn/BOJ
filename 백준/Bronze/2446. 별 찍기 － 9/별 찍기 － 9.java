import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = s.nextInt();
		for (int i = 0; i < 2*N - 1; i++) {
			int jnum = N-1 - Math.abs(i-(N-1));
			for (int j = 0; j < jnum; j++) {
				sb.append(" ");
			}
			for (int k = 0; k < 2*(N-jnum)-1; k++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
