package boj_10871;

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
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int num = Integer.parseInt(st.nextToken());
        int lownum = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<num; i++) {
            int A = Integer.parseInt(st.nextToken());
            
            if(A < lownum){
                bw.write(A+ " ");
            }
        }

        br.close();
        bw.flush();
        bw.close();
        
    }
}