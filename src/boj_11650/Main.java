package boj_11650;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int arr [][] = new int[N][2];
        
        for(int i = 0; i<N; i++) { //2���� �迭�� x,y�� ����
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        //Arrays.sort�� 1�����迭 ���Ľ��̱� ������ ���ٽ��� Ȱ���ؼ� ����
        Arrays.sort(arr, (arr1,arr2) -> {
            if(arr1[0] == arr2[0]) //�񱳴���� x���� ���ٸ�
                return Integer.compare(arr1[1],arr2[1]); //y���� ��
            else //x���� �ٸ����
                return Integer.compare(arr1[0],arr2[0]); //x���� ��
        });
        
        for(int i = 0; i<N; i++) {
            bw.write(arr[i][0] +" "+arr[i][1]+"\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}