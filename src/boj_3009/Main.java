package boj_3009;

import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int [] x = new int[3]; //x좌표 배열
        int [] y = new int[3]; //y좌표 배열
        int resultx = 0, resulty = 0; //네번째 x,y 좌표
        
        for(int i =0;i<3; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        if(x[0]==x[1]) //if else문으로 서로 같으면 다른 숫자가 네번째x값으로 들어가게
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