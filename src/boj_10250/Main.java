package boj_10250;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine()); //T: �׽�Ʈ���̽� ����
        StringTokenizer st;
        
        for(int i =0; i<T; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int H = Integer.parseInt(st.nextToken()); //H: ȣ�� ����
            int W = Integer.parseInt(st.nextToken()); //W: ȣ�� ���� �� ����
            int N = Integer.parseInt(st.nextToken()); //N: N��° �մ�
            
            int F = N%H; //F: ����
            int no = N/H+1; //no: �� ��ȣ
            
            if(N%H == 0) { //����ó��: ������������ �������, ���ȣ (+1) ������
            	F = H;
                no = N/H;
            }

            if((no)>9)
                bw.write((F)+""+(no)+"\n");
            else
                bw.write((F)+"0"+(no)+"\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}