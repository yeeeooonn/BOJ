package boj_13305;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        long dis[] = new long[N-1];
        long cost[] = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<N-1; i++) {
            dis[i] = Long.parseLong(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }
        
        long sum = 0;
        long minCost = cost[0];
        
        for(int i = 0; i< N-1; i++) {
            if(cost[i] < minCost) {
                minCost = cost[i];
            }
            sum += minCost*dis[i];
        }
        br.close();
        bw.write(sum+"");
        bw.flush();
        bw.close();
        
    }
}