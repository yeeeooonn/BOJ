package boj_4948;

import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        boolean[] prime = new boolean[246913] ; //소수체크할 배열(true:소수x, false:소수)
        prime[0] = prime [1] = true; //0과1은 소수가 아니므로 true
            	
        for(int i =2; i<=Math.sqrt(prime.length); i++) {
            if(prime[i]) continue; //이미 체크된 배열일 시 skip
            for(int j =i*i; j<prime.length; j+=i)
                prime[j] =true;
        }
        
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break; //읽은 값이 0이면 종료
            
            int count = 0; //소수 개수
            for(int i = n+1; i <=2*n ; i ++){
            	if(!prime[i]) //소수이면 카운트증가
                    count ++;
            }
            bw.write(count+"\n");
            
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}