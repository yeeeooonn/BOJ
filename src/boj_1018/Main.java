package boj_1018;

import java.io.*;
import java.util.*;

public class Main {
    static char arr[][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String n = br.readLine();
        StringTokenizer st = new StringTokenizer(n, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr= new char[N][M];
        
        for(int i = 0; i<N; i++) { //배열에 값 입력
            String str = br.readLine();
            for(int j = 0; j<M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        
        int result = 64;
        
        for(int i = 0; i< N-7; i++) {
            for(int j =0; j<M-7; j++) {
                int num = ans(i,j);
                if(num < result)
                    result = num;
            }
        }
        
        bw.write(result+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static int ans(int x, int y) {
            int B = 0; // B부터 시작할 때 다시 칠해야 하는 개수
            int W = 0; // W부터 시작할 때 다시 칠해야 하는 개수
            
            for(int i = x; i<x+8; i++) {
                int min = 64;
                for(int j = y; j <y+8; j++) {
                    if((i+j)%2 == 0) {
                        if(arr[i][j] == 'B')
                            W++;
                        else
                            B++;
                        
                    } else {
                        if(arr[i][j] == 'W')
                            W++;
                        else
                            B++;
                    }
                }
            }
            if(B> W)
                return W;
            else
                return B;
        }
} 
