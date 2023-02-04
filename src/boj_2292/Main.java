package boj_2292;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); //N: 주어진 방
        int max = 1; //max: result당 최대 방 수
        int result = 1; // result: 몇 개의 방을 지나는지
        
        while(N > max) {
            max += (6*result);
            result ++;
        }
        br.close();
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}