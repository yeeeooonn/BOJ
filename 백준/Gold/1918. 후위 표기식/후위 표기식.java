import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		Stack<Character> s = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			
			if('A' <= cur && cur<= 'Z') {
				sb.append(cur);
			}else if(cur == '(') {
				s.add(cur);
			}else if(cur == ')') {
				while(!s.isEmpty()) {
					if(s.peek() == '(') {
						s.pop();
						break;
					}
					sb.append(s.pop());
				}
			}else { //연산자
				while(!s.isEmpty() && priority(s.peek()) >= priority(cur)) {
					sb.append(s.pop());
				}
				s.add(cur);
			}
		}
		
		//남은거
		while(!s.isEmpty()) {
			sb.append(s.pop());
		}
		System.out.println(sb.toString());

	}

	static int priority(Character op) {
		if(op == '(' || op == ')') {
			return 0;
		}
		if(op == '/' || op == '*') {
			return 2;
		}
		return 1;
	}

}