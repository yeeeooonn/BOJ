import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String result = "";
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i)=='p') {
				if((str.charAt(i-1) =='a' && str.charAt(i+1)=='a') || (str.charAt(i-1) =='e' && str.charAt(i+1)=='e') || (str.charAt(i-1) =='i' && str.charAt(i+1)=='i')
						|| (str.charAt(i-1) =='o' && str.charAt(i+1)=='o') || (str.charAt(i-1) =='u' && str.charAt(i+1)=='u')) {
					i+=2;
				}
			}
			result += str.charAt(i-1);
			if(i == str.length()-1) {
				if(str.charAt(i-1)!='p')
					result += str.charAt(i);
			}
		}
		System.out.println(result);

	}
}
