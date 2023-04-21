import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static String str;
	static Stack<Character> s;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		while(str.charAt(0) != '.') {
			check();
			
			
			
			
			str = br.readLine();
		}
		System.out.println(sb.toString());

	}
	static void check() {
		s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if(cur == '(' ||cur == '[') {
				s.add(cur);
			}
			if(cur == ')') {
				if(!s.isEmpty() && s.peek() == '(') {
					s.pop();
				}else {
					sb.append("no").append("\n");
					return;
				}
			}
			if(cur == ']') {
				if(!s.isEmpty() && s.peek() == '[') {
					s.pop();
				}else {
					sb.append("no").append("\n");
					return;
				}
			}
		}
		if(s.isEmpty()) {
			sb.append("yes").append("\n");
		}else {
			sb.append("no").append("\n");
		}
	}

}