package boj_1978;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); //N: 테스트케이스 개수
        int count = 0; //count: 소수 개수 카운트
        
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        
        for(int i =0; i<N; i++){
            int A = Integer.parseInt(st.nextToken());
            boolean isPrime = true; //소수일경우 true, 아닐경우 false
            
            if(A ==1) {
                isPrime = false;
            }
            for(int j =2; j<A; j++) { //2부터 A-1 까지 나눠서 나머지가 없을 경우 false 출력
                if(A%j == 0) {
                    isPrime = false;
                }
            }
            if(isPrime) count++; //true일 경우 count올림
        }
        
        br.close();
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}