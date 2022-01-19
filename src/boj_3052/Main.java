package boj_3052;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[42];
        int count = 0;
        
        for(int i = 0; i <10; i++) {
            int A = Integer.parseInt(br.readLine());
            arr[A%42]++;
        }
        
        for(int j = 0; j<42;j++) {
            if(arr[j] != 0)
                count++;
        }
        
        br.close();
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}