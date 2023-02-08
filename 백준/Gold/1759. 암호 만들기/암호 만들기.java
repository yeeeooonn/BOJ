import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int L,C;
	static char[] alpha;
	static char[] answer;
	static boolean[] isVisit;
	static boolean[] isVowel;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		answer = new char[L];
		isVisit = new boolean[C];
		isVowel = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
			
		}
		Arrays.sort(alpha);
		for (int i = 0; i < C; i++) {
			if(alpha[i] =='a'|| alpha[i] =='e' || alpha[i] =='i' || alpha[i] =='o' || alpha[i] =='u')
				isVowel[i] = true;
		}

		combi(0,0);
		System.out.println(sb.toString());

	}
	static void combi(int cnt, int start) {
		if(cnt == L) {
			int count1 = 0;
			int count2 = 0;
			for (int i = 0; i < C; i++) {
				if(isVisit[i]&& isVowel[i]) {
					count1++;
				}else if(isVisit[i]&& !isVowel[i]) {
					count2++;
				}
			}
			if(count1 >0 && count2 >1) {
				
				for (int i = 0; i < L; i++) {
					sb.append(answer[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = start; i < C; i++) {
			isVisit[i] = true;
			answer[cnt] = alpha[i];
			combi(cnt+1,i+1);
			answer[cnt] = 0;
			isVisit[i] = false;
		}
		
	}

}
