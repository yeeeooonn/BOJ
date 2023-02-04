import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {

	static int N;
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			count = 0;
			System.out.println(isPalindrome(str)+" "+count);
		}
	}
	
	public static int isPalindrome(String str) {
		return recursion(str, 0, str.length()-1);
		
	}
	public static int recursion(String str, int l, int r) {
		count++;
		if(l>=r) return 1;
		else if(str.charAt(l)!=str.charAt(r)) return 0;
		else return recursion(str, l+1, r-1);
	}

}
