import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,d,k,c; //접시 수, 가짓 수, 연속횟수, 쿠폰번호
	static int[] sushi; //회전초밥 벨트에 놓인 번호(입력)
	static int[] count; //몇번 초밥을 먹었는지
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		count = new int[d+1];
		count[c] = 1; //쿠폰번호는 default로 1로 둔다.
		for (int i = 0; i < k; i++) {
			count[sushi[i]]++;
		}
		
		int answer = 0;
		for (int i = 1; i < d+1; i++) {
			if(count[i] > 0) {
				answer++;
			}
		}
		
		result = answer;
		
		//슬라이딩 윈도우
		int start = 1;
		while(true) {
			if(start == N+1) {
				break;
			}
			//이전거 빼줌 + 빼줄 때 count가 0이된다면  answer 값도 빼 줌
			if(count[sushi[start-1]] == 1) {
				answer--;
			}
			count[sushi[start-1]]--;
			
			
			int end = start+k-1;
			if(end > N-1) {
				end = end%N;
			}
			//새로운거 넣어줌 + 넣어줄 때 원래 카운트가 0이였다면 answer값 ++
			if(count[sushi[end]] == 0) {
				answer++;
			}
			count[sushi[end]]++;
			
			//max값 갱신
			result = Math.max(result, answer);
			
			//start값 바꿔줌
			start++;
		}

		System.out.println(result);

	}

}