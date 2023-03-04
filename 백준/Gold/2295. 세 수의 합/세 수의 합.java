import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] nums;
	static int[] choice2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		choice2 = new int[N*N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);

		//임의의 두 수의 합을 choice2 배열에 넣음
		int index = 0;
		for (int x = 0; x < N; x++) {
			for (int y = x; y < N; y++) {
				choice2[index++] = nums[x]+ nums[y];
			}
		}
		//정렬 -> index까지
		Arrays.sort(choice2, 0, index-1);
		
		//k - z 가 choice2에 있는지 뒤부터 탐색 -> 발견하면 return 
		for (int k = N-1; k >= 0; k--) {
			for (int z = k; z >= 0; z--) {
				int find = Arrays.binarySearch(choice2,0,index-1,nums[k]-nums[z]);
				if(find >= 0) {
					System.out.println(nums[k]);
					return;
				}
			}
		}
	}
}