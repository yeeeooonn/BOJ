package boj_11399;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int time[] = new int[N];
        
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");;
        for(int i = 0; i<N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(time);
        int ans_time = 0;
        int acc = 0;
        for(int i = 0; i < N; i ++) {
        	acc += time[i];
        	ans_time += acc;
        }
        
        br.close();
        bw.write(ans_time+"");
        bw.flush();
        bw.close();
    }
}