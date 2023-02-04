package boj_2577;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        String mul = Integer.toString(A*B*C);
        int[] arr = new int[10];
        
        for(int i = 0; i< mul.length(); i++) {
            arr[(mul.charAt(i))-'0']++;
        }
        for(int r = 0; r<10; r++) {
            bw.write(arr[r] +"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}