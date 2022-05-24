package boj_13300;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int [][] arr = new int[7][2];
        int count = 0;
        
        for(int i = 0; i < N; i ++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	if(Integer.parseInt(st.nextToken()) == 0)
        		arr[Integer.parseInt(st.nextToken())][0] ++;
        	else
        		arr[Integer.parseInt(st.nextToken())][1] ++;
        }
        
        for(int i = 1; i < 7; i++) {
        	for(int j = 0; j < 2; j ++) {
        		if(arr[i][j]==0)
        			continue;
        		
        		count += arr[i][j]/K;
        		if(arr[i][j]%K !=0)
        			count++;
        	}
        }
        
        br.close();
        bw.write(count+"");
        bw.flush();
        bw.close();
		
	}
}
