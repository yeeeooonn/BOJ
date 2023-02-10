import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int S,P;
	static int[] need = {0,0,0,0}; //필요한 개수 저장 배열
	static int[] check; //pwd에 알파벳 몇개씩 있는지
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		
		String s = br.readLine();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			need[i] = Integer.parseInt(st.nextToken());
		}
		
		check = new int[4];
		for (int i = 0; i < P; i++) { //초기 값 넣어주기
			if(s.charAt(i)=='A') check[0]++;
			if(s.charAt(i)=='C') check[1]++;
			if(s.charAt(i)=='G') check[2]++;
			if(s.charAt(i)=='T') check[3]++;
		}
		count=1;
		if(!isPossible(check)) count = 0;
	
		
		for (int i = P; i < S; i++) { //문자열 담긴 갯수만큼 카운트 올리고
			count++;
			//다음 수 카운트
			if(s.charAt(i)=='A') check[0]++;
			if(s.charAt(i)=='C') check[1]++;
			if(s.charAt(i)=='G') check[2]++;
			if(s.charAt(i)=='T') check[3]++;
			//제일 이전 수 빼주기
			if(s.charAt(i-P)=='A') check[0]--;
			if(s.charAt(i-P)=='C') check[1]--;
			if(s.charAt(i-P)=='G') check[2]--;
			if(s.charAt(i-P)=='T') check[3]--;
			
			//필요한문자개수보다 적으면 카운트 빼기
			if(!isPossible(check)) count--;
			
		}
		System.out.println(count);
	}
	
	static boolean isPossible(int[] check) {
		for (int j = 0; j < 4; j++) { 
			if(check[j]< need[j]) {
				return false;
			}
		}
		return true;
	}
}