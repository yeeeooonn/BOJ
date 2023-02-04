package boj_1436;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        int an = 666;
        
        while(count != N) { //count랑 N이 같을때까지
            String str = Integer.toString(an); //문자열로 변환해서
            
            if(str.indexOf("666") >=0) { //666이 들어있으면 count랑 an증가
            	count ++;
            	an++;
            } else {
            	an++;
            }
        }
        
        bw.write(an-1+"");
        br.close();
        bw.flush();
        bw.close();
        
    }
}