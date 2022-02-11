package boj_1929;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int M = Integer.parseInt(st.nextToken()); 
        int N = Integer.parseInt(st.nextToken());
        
        boolean[] prime = new boolean[N+1]; //�Ҽ� üũ�� �迭
        //true:�Ҽ��ƴ� false:�Ҽ�
        prime[0] = prime[1] = true;
        
        for(int i =2; i<=Math.sqrt(prime.length);i++) {
            if(prime[i]) continue; //�̹� üũ�� �迭�� �� skip
            for(int j = i*i; j<prime.length;j+=i) { //i�� ������� �ɷ���
                prime[j] = true;
            }
        }
        
        for(int i = M; i<=N; i++) { //true:�Ҽ��ƴ� false:�Ҽ�
            if(!prime[i])
                bw.write(i+"\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}