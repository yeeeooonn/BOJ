import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tlen = text.length;
		int plen = pattern.length;
		
		//pi 배열 만들기
		int[] pi = new int[plen];
		int idx = 0;
		for (int i = 1; i < plen; i++) {
			while(idx>0 && pattern[i] != pattern[idx]) {
				idx = pi[idx-1];
			}
			if(pattern[i] == pattern[idx]) {
				idx++;
				pi[i]= idx;
			}
		}
		
		int count = 0; //몇 번 나왔는지 세는 함수
		List<Integer> list = new ArrayList<>(); //몇 번째 위치에 있는지 저장 리스트
		
		//i : 텍스트 포인터, idx : 패턴 포인터
		idx = 0;
		for (int i = 0; i < tlen; i++) {
			
			while(idx > 0 && text[i] != pattern[idx]) {
				idx = pi[idx-1];
			}
			if(text[i] == pattern[idx]) { // 두 글자가 일치 할 때
				if(idx == plen-1) { //마지막 글자 일 때
					count++;
					list.add(i-idx+1);
					idx = pi[idx];
				}else {
					idx++;
				}
			}
		}
		sb.append(count).append("\n");
		if(count>0) {
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i)).append("\n");
			}
		}
		System.out.println(sb.toString());

	}

}