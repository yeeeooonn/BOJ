package boj_1002;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); //�׽�Ʈ���̽� ����
        
        for(int i =0; i<N; i++){ //�׽�Ʈ���̽� ������ŭ �ݺ�
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            
            int dis = (int)Math.pow((x1-x2),2) + (int)Math.pow((y1-y2),2); // (x1,y1)�� (x2,y2) �Ÿ� ����
            int sumr = (int)Math.pow(r1+r2, 2); //������ ���� ����
            int subr = (int)Math.pow(Math.abs(r2-r1), 2); //������ ���� ����
            
            if((x1==x2)&&(y1==y2)&&(r1==r2)) {
                bw.write("-1\n");
            } else if (dis > sumr) { //������ �պ��� �Ÿ��� �涧 (������ �ʴ´�)
                bw.write("0\n");
            } else if( dis < subr) { //���ȿ� ���� ������ �������� ���� �� (������ �ʴ´�)
            	bw.write("0\n");
            } else if (dis == subr) { //�����Ҷ� (�� ������ ������)
            	bw.write("1\n");
            } else if(dis == sumr) { //�����Ҷ� (�� ������ ������)
            	bw.write("1\n");
            }  else { //������ �պ��� �Ÿ��� ª���� (�� ������ ������)
            	bw.write("2\n");
            }
           
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}