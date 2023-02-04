package boj_2750;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N]; 
        
        for(int i =0; i<N; i++) { //배열에 값 대입
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        //선택정렬
        for(int i = 0; i<N-1; i++) {
            for(int j =i+1; j<N; j++) {
                
                if(arr[i]>arr[j]) {
                    int a = arr[i];
                    arr[i] = arr[j];
                    arr[j] = a;
                }
            }
        }
        
        for(int i = 0; i<N; i++) {
            bw.write(arr[i]+"\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}