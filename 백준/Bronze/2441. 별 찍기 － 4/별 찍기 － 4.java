import java.util.Scanner;
//StringBuilder 사용
public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				sb.append(" ");
			}
			for (int k = 0; k < N-i; k++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString()); //immutterable
	}
}
