package boj_10808;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        
        int [] arr = new int[26];
        
        
        for(int i = 0; i <str.length(); i++) 
        	arr[(int)str.charAt(i)-97] ++;
        
        for(int i = 0; i < arr.length; i++) 
        	bw.write(arr[i]+" ");;

        
        br.close();
        bw.flush();
        bw.close();
    }
}