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
        
        int N = Integer.parseInt(br.readLine()); //N: �־��� ��
        int max = 1; //max: result�� �ִ� �� ��
        int result = 1; // result: �� ���� ���� ��������
        
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