import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int weight;
	static int count5;
	static int count3;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		weight = Integer.parseInt(br.readLine());
		
		//5키로짜리 넣을 수 있을때까지 넣음
		int copyWeight= weight;
		while(count5 < copyWeight/5) {
			weight = weight-5;
			count5++;
		}
		
		while(weight !=0) {
			//3키로짜리 넣을 수 있을때까지 넣음
			copyWeight= weight;
			int i =0;
			while(i < copyWeight/3) {
				weight = weight-3;
				count3++;
				i++;
			}
			//무게 0안 되면 5추가
			if(weight !=0) {
				if(count5 == 0)
					break;
				weight = weight+5;
				count5--;
			}
		}
		System.out.println((weight==0) ? count3+count5 : -1);
	}
}