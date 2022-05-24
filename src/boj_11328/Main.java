package boj_11328;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        
        for(int i = 0; i <N; i ++) {
        	
        	int alphabet[] = new int[26];
        	boolean check = true;

        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        	String a = st.nextToken();
        	String b = st.nextToken();
        	
        	for(int j = 0; j < a.length(); j++) {
        		alphabet[(int)a.charAt(j)-97]+=1;
        	}
        	
        	for(int j = 0; j < b.length(); j++) {
        		alphabet[(int)b.charAt(j)-97]-=1;
        	}
        	
        	for(int j = 0; j <alphabet.length; j++) {
        		if(alphabet[j] != 0)
        			check = false;
        	}
        	
        	if(check== false)
        		bw.write("Impossible\n");
        	else
        		bw.write("Possible\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
		
	}
}
