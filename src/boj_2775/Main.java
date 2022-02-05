package boj_2775;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine()); //t: 테스트케이스 개수
        
        for(int i = 0; i<t; i++){
            int k = Integer.parseInt(br.readLine()); //k: 아파트 층수
            int n = Integer.parseInt(br.readLine()); //n: 아파트 호수
            
            int arr[][] = new int[k+1][n];
            
            for(int j = 0; j< n; j++) { //0층에 1~n 넣기
                arr[0][j] = j+1;
            }
            for(int j = 0; j<k+1; j++) { //모든층 1호에 1넣기
                arr[j][0] =1;
            }
             
            for(int j =1; j<k+1; j++) {
                for(int l = 1; l<n; l++) {
                    arr[j][l] = arr[j][l-1] +arr[j-1][l]; //같은층 앞호수 + 밑층 같은호수
                }
            }
            bw.write(arr[k][n-1]+"\n"); //출력 arr[k][n-1]
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}