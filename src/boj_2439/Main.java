package boj_2439;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num = Integer.parseInt(br.readLine());
        
        for(int i=0; i<num; i++) {
            for(int j=1; j<num-i; j++) {
                bw.write(" ");
            }
            for(int k=0; k<=i; k++) {
                bw.write("*");
            }
            bw.newLine();
        }

    
        br.close();
        bw.flush();
        bw.close();
        
    }
}
