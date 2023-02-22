import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int length;
	static boolean isFelen;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while(!(str = br.readLine()).equals("0")) {
			length = str.length();
			isFelen = true;
			int index1 = 0;
			int index2 = length-1;
			while(index1 <= index2) {
				//System.out.println(str.charAt(index1)+" "+str.charAt(index2));
				if(str.charAt(index1) != str.charAt(index2)) {
					isFelen = false;
				}
				index1++;
				index2--;
			}
			if(isFelen) {
				System.out.println("yes");
			}
			if(!isFelen) {
				System.out.println("no");
			}
		}
	}
}