import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//이분탐색이용
public class Main {
	static int N;
	static int index;
	static int nums[];
	static int numsCopy[]; //기존 배열 순서 저장
	static int numsDis[]; //중복 제거 배열
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		numsCopy = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			numsCopy[i] = nums[i];
		}
		Arrays.sort(nums);
		int acc = nums[0];
		//0~ index 까지 배열 -> 중복제거
		index = 1;
		for (int i = 1; i < N; i++) {
			if(acc != nums[i]) {
				nums[index++] = nums[i];
				acc = nums[i];
			}
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(find(numsCopy[i])).append(" ");
		}
		System.out.println(sb.toString());
		

	}
	static int find(int target) {
		int s = 0;
		int e = index-1;
		while(s<=e) {
			int mid = (s+e)/2;
			if(target < nums[mid]) {
				e = mid-1;
			}
			if(target > nums[mid]) {
				s = mid+1;
			}
			if(target == nums[mid]) {
				return mid;
			}
		}
		return 0;
	}

}