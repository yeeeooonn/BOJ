package boj_1946;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i< T; i++) {
            int N = Integer.parseInt(br.readLine());
            
            int rank[][] = new int[N][2];
            
            StringTokenizer st ;
            for(int j = 0; j<N; j++){
                st = new StringTokenizer(br.readLine()," ");
                rank[j][0] = Integer.parseInt(st.nextToken());
                rank[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(rank,(a,b)-> {
                return Integer.compare(a[0],b[0]);
            });
            
            
            int count = 1;
            int num = rank[0][1];
            
            for(int j = 1; j<N; j++) {
                if(rank[j][1] < num){
                    num = rank[j][1];
                    count++;
                }
            }
            bw.write(count+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}