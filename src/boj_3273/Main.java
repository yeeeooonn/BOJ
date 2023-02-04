package boj_3273;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int []num = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n ; i ++)
        	num[i] = Integer.parseInt(st.nextToken());
        
        int x = Integer.parseInt(br.readLine());
        
        int count = 0;
        int start = 0;
        int end = n-1;
        Arrays.sort(num);
        

        while(start<end) {
        	if(num[start] + num[end] == x)
        		count++;
        	if(num[start] + num[end] <= x)
        		start++;
        	else
        		end--;
        }

        br.close();
        bw.write(count+"");
        bw.flush();
        bw.close();
    }

}
