package boj_2941;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine(); //문자열 입력받기
        String copy1 = str; //문자열을 copy1에 복사
        int count = 0; //count: 총 알파벳 개수
        
        for(int i = 0; i <str.length()-2; i++) { //문자열을 순회하면서 3글자 크로아티아알파벳 찾기
            String A = str.substring(i,i+3);
            if(A.equals("dz=")) {
            	copy1 = copy1.replace(A, " "); //"dz="에 해당하는 문자열을 찾으면 공백으로 바꿔주기 -> 공백이 없으면 추후에 붙혀져서 두문자열제거할떄 에러남
                count ++;
            }
        }
        
        String copy2 = copy1; // 3글자가 제거된 문자열을 copy2에 복사
        for(int i = 0; i <copy1.length()-1; i++) { //문자열을 순회하면서 2글자 크로아티아알파벳 찾기
        	String A = copy1.substring(i,i+2);
        	
        	if(A.equals("c=") || A.equals("c-") || A.equals("d-") || A.equals("lj") || A.equals("nj") || A.equals("s=") || A.equals("z=")) {
                copy2 = copy2.replace(A, " ");
                count ++;
            }
        }
        
        for(int i = 0; i< copy2.replaceAll("\\s", "").length(); i++) { //남은문자열 공백제거한후, 개수세서 카운트올리기
            count ++;
        }

        br.close();
        bw.write(count+"");
        bw.flush();
        bw.close();
        
    }
}
