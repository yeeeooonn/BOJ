import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] nums;
	static int[] binary;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		binary = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = 0; //이분탐색 인덱스(마지막)
		
		binary[0] = nums[0];
		for (int i = 1; i < N; i++) {
/*			System.out.println("i=>" + i+" "+nums[i]);
			for (int j = 0; j < N; j++) {
				System.out.print(binary[j]+" ");
			}
			System.out.println();*/
			if(nums[i] > binary[index]) {
				binary[++index] = nums[i];
			}else {
				int temp = Arrays.binarySearch(binary, 0, index, nums[i]); //위치반환
				if(temp < 0) {
					temp = Math.abs(temp+1);
				}
				binary[temp] = nums[i];
			}
		}
		
		
/*		for (int i = 0; i < N; i++) {
			System.out.print(binary[i]+" ");
		}
		System.out.println();*/
		
		//binary 크기 계산
		for (int i = N-1; i >= 0; i--) {
			if(binary[i] != 0) {
				System.out.println(i+1);
				break;
			}
		}
		
		

	}

}