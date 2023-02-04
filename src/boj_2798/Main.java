package boj_2798;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        StringTokenizer st1 = new StringTokenizer(str, " ");
        
        int N = Integer.parseInt(st1.nextToken()); //N: ī���� ����
        int M = Integer.parseInt(st1.nextToken()); //M: ���� �ʾƾߵǴ� ��
        
        int arr[] = new int[N];
        int result = 0; //�����
        
        String num = br.readLine();
        StringTokenizer st2 =new StringTokenizer(num, " ");
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
       
        
        for(int i = 0; i<N-2;i++) { //0~N-2 ������ ��ȸ
            for(int j =i+1; j<N-1; j++) { //ù��°ī�����~N-1���� ��ȸ
                for(int k =j+1; k<N; k++) { //�ι�°ī����� ~ N���� ��ȸ
                    
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