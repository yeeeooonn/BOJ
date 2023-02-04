package boj_1978;

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
        
        int N = Integer.parseInt(br.readLine()); //N: �׽�Ʈ���̽� ����
        int count = 0; //count: �Ҽ� ���� ī��Ʈ
        
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        
        for(int i =0; i<N; i++){
            int A = Integer.parseInt(st.nextToken());
            boolean isPrime = true; //�Ҽ��ϰ�� true, �ƴҰ�� false
            
            if(A ==1) {
                isPrime = false;
            }
            for(int j =2; j<A; j++) { //2���� A-1 ���� ������ �������� ���� ��� false ���
                if(A%j == 0) {
                    isPrime = false;
                }
            }
            if(isPrime) count++; //true�� ��� count�ø�
        }
        
        br.close();
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}