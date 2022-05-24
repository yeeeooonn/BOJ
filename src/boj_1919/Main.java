package boj_1919;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String a = br.readLine();
        String b = br.readLine();
        
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        
        for(int i = 0; i< a.length(); i++)
        	arr1[(int)a.charAt(i)-97] ++;
        for(int i = 0; i< b.length(); i++)
        	arr2[(int)b.charAt(i)-97] ++;
        
        int count =0;
        
        for(int i = 0; i<arr1.length; i++) {
        	if(arr1[i] ==arr2[i])
        		continue;
        	else
        		count += Math.abs(arr1[i]-arr2[i]);
        }
        
        br.close();
        bw.write(count+"");
        bw.flush();
        bw.close();
		
	}
}
