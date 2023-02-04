package boj_4948;

import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        boolean[] prime = new boolean[246913] ; //�Ҽ�üũ�� �迭(true:�Ҽ�x, false:�Ҽ�)
        prime[0] = prime [1] = true; //0��1�� �Ҽ��� �ƴϹǷ� true
            	
        for(int i =2; i<=Math.sqrt(prime.length); i++) {
            if(prime[i]) continue; //�̹� üũ�� �迭�� �� skip
            for(int j =i*i; j<prime.length; j+=i)
                prime[j] =true;
        }
        
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break; //���� ���� 0�̸� ����
            
            int count = 0; //�Ҽ� ����
            for(int i = n+1; i <=2*n ; i ++){
            	if(!prime[i]) //�Ҽ��̸� ī��Ʈ����
                    count ++;
            }
            bw.write(count+"\n");
            
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}