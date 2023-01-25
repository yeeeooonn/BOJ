import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = in.nextInt();
		char [][] secret = {
				{'A','0','0','0','0','0','0'},
				{'B','0','0','1','1','1','1'},
				{'C','0','1','0','0','1','1'},
				{'D','0','1','1','1','0','0'},
				{'E','1','0','0','1','1','0'},
				{'F','1','0','1','0','0','1'},
				{'G','1','1','0','1','0','1'},
				{'H','1','1','1','0','1','0'}
		};
	
		String str = in.next();
		String result = "";
		
		for (int i = 0; i < N; i++) {
			
			String str2 = str.substring(6*i, 6*(i+1));
			char c = '0';
			
			for (int j = 0; j < 8; j++) {
				
				int acc = 0; //틀린갯수누적
				for (int k = 1; k <= 6; k++) {
					if(secret[j][k] != str2.charAt(k-1)) {
						acc++;
						if(acc == 2) {
							 break;
						}
					}
					if(k == 6) {
						c= secret[j][0];
					}
				}
			}
			if(c =='0') {
				System.out.println(i+1);
				result += c;
				break;
			}
			result += c;
		}
		
		if(!result.contains("0"))
			System.out.println(result);
	}
	
}