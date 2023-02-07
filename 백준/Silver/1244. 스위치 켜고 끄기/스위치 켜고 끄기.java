import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; //스위치 개수
	static int[] s;//스위치 상태
	static int M;
	static int a[] = new int[2];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		N = Integer.parseInt(br.readLine());
		s = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			a[0] = Integer.parseInt(st.nextToken());
			a[1] = Integer.parseInt(st.nextToken());
			
			if(a[0]==1) {
				boy(a[1]);
			}else {
				girl(a[1]-1);
			}
		}
		//출력
		int count = 1;
		for (int i = 0; i <N; i++) {
			sb.append(s[i]+" ");
			count++;
			if(count>20) {
				sb.append("\n");
				count = 1;
			}
		}
		System.out.println(sb.toString());
		

	}
	static void girl(int i) { //여학생
		if(s[i]==1) {
			s[i]=0;
		} else s[i]=1;
		
		int j =1;
		if(i-j <0 || i+j>=N) return;
		while(s[i-j] == s[i+j]) {
			if(s[i-j]==1) {
				s[i-j]=0;
				s[i+j]=0;
			}else {
				s[i-j]=1;
				s[i+j]=1;
			}
			j++;
			if(i-j <0 || i+j>=N) return;
		}
	}
	static void boy(int i) { //남학생
		for (int j = 0; j < N; j++) {
			if((j+1)%i ==0) {
				if(s[j] == 1) s[j]=0;
				else s[j]=1;
			}
		}
	}

}
