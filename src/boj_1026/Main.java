package boj_1026;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        int B[] = new int[N];
        
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<N; i++) {
            A[i] = Integer.parseInt(st1.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int sum = 0;
        for(int i = 0; i<N; i++) {
            sum += A[i]*B[N-1-i];
        }
        
        br.close();
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}