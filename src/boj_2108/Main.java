package boj_2108;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int check[] = new int[8001]; //�ֺ� ���ϱ� ���� �迭_ -4000~4000 ���� 8001��
        
        double sum = 0;
        int mid = Math.round(N/2); //�߾Ӱ� �ڸ�
        
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            check[arr[i]+4000]++; //arr1��+4000�� �ؼ� arr2�� ī��Ʈ�� �ø�
        }

        Arrays.sort(arr); //�迭 ����
        
        bw.write(Math.round(sum/N)+"\n"); //������
        bw.write(arr[mid]+"\n"); //�߾Ӱ�
        bw.write(manny(arr, check)+"\n"); //�ֺ�
        bw.write(arr[N-1] - arr[0] +""); //����
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    static int manny(int[] arr, int[]check) { //�ֺ� ���ϴ� �Լ�
        int max = 0;
        List<Integer> list = new ArrayList<>(); //�ֺ� ���ϱ� ���� ����Ʈ
        
        for(int i = 0; i<8001; i++) { //�ֺ� ���� ������ üũ(max��)
           if(max < check[i]) {
               max = check[i];
           }
        }
        for(int i = 0; i<8001; i++) {
            if(check[i] == max)
                list.add(i-4000); //+4000 ������� �ٽ� ���ֱ�
        }
        if(list.size()==1) { //�ֺ��� �ϳ� �ΰ��
            return list.get(0); //0��° �ε��� ����
        } else { //�ֺ��� �ΰ� �̻��ΰ��
            Collections.sort(list); //���� ��,
            return list.get(1); //1��° �ε��� ����(�ι�°�� ���� ��)
        } 
        
    }
}