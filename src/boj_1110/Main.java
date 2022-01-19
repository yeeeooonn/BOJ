package boj_1110;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int str = Integer.parseInt(br.readLine());
        int N = str;
        int count = 0;
        
        while(true) {
            N = ((N%10)*10) + (((N/10)+(N%10))%10);
            count ++;
            
            if(str == N) {
                break;
            }
        }
        br.close();
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();   
    }
}