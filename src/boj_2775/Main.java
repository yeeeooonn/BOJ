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
        
        int t = Integer.parseInt(br.readLine()); //t: �׽�Ʈ���̽� ����
        
        for(int i = 0; i<t; i++){
            int k = Integer.parseInt(br.readLine()); //k: ����Ʈ ����
            int n = Integer.parseInt(br.readLine()); //n: ����Ʈ ȣ��
            
            int arr[][] = new int[k+1][n];
            
            for(int j = 0; j< n; j++) { //0���� 1~n �ֱ�
                arr[0][j] = j+1;
            }
            for(int j = 0; j<k+1; j++) { //����� 1ȣ�� 1�ֱ�
                arr[j][0] =1;
            }
             
            for(int j =1; j<k+1; j++) {
                for(int l = 1; l<n; l++) {
                    arr[j][l] = arr[j][l-1] +arr[j-1][l]; //������ ��ȣ�� + ���� ����ȣ��
                }
            }
            bw.write(arr[k][n-1]+"\n"); //��� arr[k][n-1]
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}