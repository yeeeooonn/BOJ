package boj_7568;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); //�׽�Ʈ���̽� ����
        int arr [][] = new int[N][2]; //������,Ű�� ������ 2�����迭 ����
        
        for(int i = 0; i <N; i++) { //������ Ű ����
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i<N; i++) {
            int rank = 1; //rank �⺻�� 1
            for(int j = 0; j<N; j++) {
                if((arr[i][0] < arr[j][0])&&(arr[i][1] < arr[j][1]))
                    rank++; 
            }
            bw.write(rank+" ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}