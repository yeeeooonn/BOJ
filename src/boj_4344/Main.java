package boj_4344;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine()); //N:테스트케이스 수
        
        for(int i = 0; i<N; i++) {
            int sum = 0;
            double above =0;
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken()); //S: 학생 수
            int[] score = new int[S]; //score[]: 학생들의 점수 배열
            
            for(int j = 0; j<S; j++) {
                score[j] = Integer.parseInt(st.nextToken());
                sum += score[j];
            }
            
            for(int k = 0; k<S; k++) {
                if(score[k]> (sum/S)) {
                    above++;
                }
            }
            String result = String.format("%.3f", (above/S*100));
            bw.write(result+"%\n");
            
        }
        br.close();
        bw.flush();
        bw.close();
    }
}