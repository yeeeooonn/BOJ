package boj_8958;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[80];
        
        
        for(int i = 0; i<N; i++) {
            String str = br.readLine();
            
            int sum = 0;
            int bs = 0; //beforescore 에 전 스코어 점수 저장
            for(int j = 0; j<str.length(); j++) {
 
                if(str.charAt(j) == 'O') {
                    sum += (bs+1);
                    bs += 1;
                } else {
                    bs = 0;
                }
            }
            
            bw.write(sum + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}