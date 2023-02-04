package boj_1011;

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
        for(int i =0; i<N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            int count = 0;
            int dis = B-A;
            int max = (int)Math.sqrt(dis); //소수점 버림(루트 함수)
            
            if(max == Math.sqrt(dis)) { //소숫점 버린것과 안버린 것이 같으면 제곱근부분
                bw.write(2*max -1 +"\n");
            } else if(dis<= max*max + max) { //제곱근 다음부분 dis부터 max개
                bw.write(2*max+"\n");
            } else {
                bw.write(2*max+1+"\n");
            }
            
            
        }
        br.close();
        bw.flush();
        bw.close();
    }
}