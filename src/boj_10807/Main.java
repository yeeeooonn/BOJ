package boj_10807;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        for(int i = 0; i <N; i ++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int v = Integer.parseInt(br.readLine());
        int count = 0;
        
        for(int i = 0; i <N; i ++) {
        	if(arr[i] == v)
        		count++;
        }
        
        br.close();
        bw.write(count+"");
        bw.flush();
        bw.close();
        
    }
}