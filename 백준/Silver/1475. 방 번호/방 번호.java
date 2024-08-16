import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int []num = new int[10];

		String str = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			num[(int)str.charAt(i)-48]++;
		}
	
		if((num[6]+num[9])%2 == 0) {
			num[6] = (num[6]+num[9]) /2 ;
		} else {
			num[6] = (num[6]+num[9]) /2 +1 ;
		}
		num[9] = num[6];
		
		
		int max = 0;
		
		for(int i = 0; i <num.length; i++) {
			if(max < (num[i]))
				max = num[i];
		}
		
		br.close();
		bw.write(max+"");
		bw.flush();
		bw.close();
	}
	
}