import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		
		for (int i = N; i > 0; i--) {
			for (int k = 0; k < i; k++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
