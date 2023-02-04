package boj_3009;

import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int [] x = new int[3]; //x��ǥ �迭
        int [] y = new int[3]; //y��ǥ �迭
        int resultx = 0, resulty = 0; //�׹�° x,y ��ǥ
        
        for(int i =0;i<3; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        if(x[0]==x[1]) //if else������ ���� ������ �ٸ� ���ڰ� �׹�°x������ ����
        	resultx = x[2];
        else if(x[1]== x[2])
        	resultx = x[0];
        else
        	resultx = x[1];
        
        if(y[0]==y[1])
        	resulty = y[2];
        else if(y[1]== y[2])
        	resulty = y[0];
        else
        	resulty = y[1];
        
        bw.write(resultx+ " "+ resulty);
        
        br.close();
        bw.flush();
        bw.close();
    }
}