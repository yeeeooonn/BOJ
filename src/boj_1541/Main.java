package boj_1541;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] str = br.readLine().split("-");
        
        int answer = 0;
        
        for(int i = 0; i< str.length; i++) {
        	int sum = 0;
        	
        	String[] str2 = str[i].split("\\+");
        	for(int j = 0; j< str2.length; j++) {
        		sum += Integer.parseInt(str2[j]);
        	}
        	if(i ==0)
        		answer += sum;
        	else
        		answer -= sum;
        }
        
        bw.write(answer+"");
        bw.flush();
        bw.close();
        
    }
}