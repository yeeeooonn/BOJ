package boj_2839;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); //N:�Է¹޴� ��
        int count = 0;// count: ���� ����
        
        while(true) {
            if(N%5 ==0) { //5�� ������ ������ ��
                bw.write(N/5+count+"");
                break;
            } else if(N<0){
                bw.write("-1");
                break;
            }
            N = N-3; //n�� 3kg�� ���� count�� �÷��� -> 3kg ������ �ϳ� �� �Ͱ�����
            count ++;
        }
        br.close();
        bw.flush();
        bw.close();        
        
    }
}