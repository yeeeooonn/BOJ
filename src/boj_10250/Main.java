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
        
        int T = Integer.parseInt(br.readLine()); //T: 테스트케이스 갯수
        StringTokenizer st;
        
        for(int i =0; i<T; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int H = Integer.parseInt(st.nextToken()); //H: 호텔 높이
            int W = Integer.parseInt(st.nextToken()); //W: 호텔 가로 방 개수
            int N = Integer.parseInt(st.nextToken()); //N: N번째 손님
            
            int F = N%H; //F: 층수
            int no = N/H+1; //no: 룸 번호
            
            if(N%H == 0) { //예외처리: 나눠떨어지면 꼭대기층, 룸번호 (+1) 안해줌
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