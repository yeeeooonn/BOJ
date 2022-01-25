package boj_1316;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); //N: 테스트케이스 개수
        int count = 0; //count: 총 그룹단어 개수
        
        for(int i = 0; i<N; i++) {
            String[] str = br.readLine().split(""); //문자열 받아서 문자마다 배열에 저장
            int check = 1; //그룹단어인지 체크
            
            for(int j = 0; j<str.length-1; j++) { //문자열을 저장한 배열의 길이만큼 연속된 수 비교
                String A = str[j];
                String B = str[j+1];
                String[] copy = Arrays.copyOfRange(str,0, j); //str[0~j] 까지 배열 복사
                
                
                for(int k = 0; k<copy.length; k++) { //연속된수가 같지않고 복사된배열에 비교문자(B)가 포함되어있으면 그룹단어가아니라는(check=0)
                	if((!A.equals(B)) && (B.contains(copy[k]))) {
                        check = 0;
                    }
                }
                
            }
            
            if(check == 1) { //그룹단어이면 카운트올리기
                count ++;
            }
            
        }

        br.close();
        bw.write(count+"");
        bw.flush();
        bw.close();
        
    }
}

