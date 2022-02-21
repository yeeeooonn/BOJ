package boj_4153;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            if(A==0&&B==0&&C==0) break;
            
            if((B*B + C*C) == A*A) {
                bw.write("right\n");
            } else if((A*A + C*C) == B*B) {
                bw.write("right\n");
            } else if((A*A + B*B) == C*C){
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }
            
            
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}