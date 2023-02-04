package boj_11047;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String num = br.readLine();
        StringTokenizer st = new StringTokenizer(num," ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int coin[] = new int[N];
        for(int i = 0; i<N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        
        int sum = 0;
        int count = 0;
        
        for(int i = N-1 ; i>=0; i--) {
            while(K >= sum + coin[i]) {
                sum += coin[i];
                count++;
            }
            if(K == sum) break;
        }
        
        bw.write(count+"");
        
        br.close();
        bw.flush();
        bw.close();
    }
}