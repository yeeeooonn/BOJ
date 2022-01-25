package boj_1316;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); //N: �׽�Ʈ���̽� ����
        int count = 0; //count: �� �׷�ܾ� ����
        
        for(int i = 0; i<N; i++) {
            String[] str = br.readLine().split(""); //���ڿ� �޾Ƽ� ���ڸ��� �迭�� ����
            int check = 1; //�׷�ܾ����� üũ
            
            for(int j = 0; j<str.length-1; j++) { //���ڿ��� ������ �迭�� ���̸�ŭ ���ӵ� �� ��
                String A = str[j];
                String B = str[j+1];
                String[] copy = Arrays.copyOfRange(str,0, j); //str[0~j] ���� �迭 ����
                
                
                for(int k = 0; k<copy.length; k++) { //���ӵȼ��� �����ʰ� ����ȹ迭�� �񱳹���(B)�� ���ԵǾ������� �׷�ܾ�ƴ϶��(check=0)
                	if((!A.equals(B)) && (B.contains(copy[k]))) {
                        check = 0;
                    }
                }
                
            }
            
            if(check == 1) { //�׷�ܾ��̸� ī��Ʈ�ø���
                count ++;
            }
            
        }

        br.close();
        bw.write(count+"");
        bw.flush();
        bw.close();
        
    }
}

