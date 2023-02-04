import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		int [] arr = new int[30];
		int [] arr1 = new int[2]; //미제출
		int cnt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 28; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num-1] = 1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				arr1[cnt++] = i;
			}
		}
		
		Arrays.sort(arr1);
		System.out.println(arr1[0]+1);
		System.out.println(arr1[1]+1);
	}

}
