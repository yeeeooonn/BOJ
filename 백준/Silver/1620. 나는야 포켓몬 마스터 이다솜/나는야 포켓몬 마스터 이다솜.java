import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static String[] book;
	static HashMap<String,Integer> map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		book = new String[N];
		map = new HashMap<String,Integer>();
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			book[i] = name;
			map.put(name, i+1);
		}
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if((str.charAt(0)-'0') <10) { //앞자리가 10 미만일경우(숫자 입력받음)
				sb.append(book[Integer.parseInt(str)-1]).append("\n");
			}else {
				sb.append(map.get(str)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}