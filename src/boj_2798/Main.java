package boj_2798;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        StringTokenizer st1 = new StringTokenizer(str, " ");
        
        int N = Integer.parseInt(st1.nextToken()); //N: 카드의 개수
        int M = Integer.parseInt(st1.nextToken()); //M: 넘지 않아야되는 수
        
        int arr[] = new int[N];
        int result = 0; //결과값
        
        String num = br.readLine();
        StringTokenizer st2 =new StringTokenizer(num, " ");
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
       
        
        for(int i = 0; i<N-2;i++) { //0~N-2 까지만 순회
            for(int j =i+1; j<N-1; j++) { //첫번째카드다음~N-1까지 순회
                for(int k =j+1; k<N; k++) { //두번째카드다음 ~ N까지 순회
                    
                    int hap = arr[i]+arr[j]+arr[k];
                    
                    if(M == hap) {
                        result = hap;
                        break;
                    }
                    
                    if(result< hap && hap<M) {
                        result = hap;
                    }
                }
            }
        }
        
        bw.write(result+"");
        br.close();
        bw.flush();
        bw.close();
        
    }
}