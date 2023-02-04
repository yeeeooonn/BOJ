package boj_18870;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int clone[] = new int[N]; //���� �迭
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        
        for(int i = 0; i<N; i++) {
            arr[i] = clone[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(clone); //���� �迭 ����
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int count =0;
        
        for(int i = 0; i<clone.length; i++) {
            if(!hmap.containsKey(clone[i])) //�ߺ�����
            	hmap.put(clone[i], count++); //���ĵ� �迭 ������ ���� �ְ� ī��Ʈ ����
        }
        for(int i =0; i<N; i++) {
        	bw.write(hmap.get(arr[i])+" "); //���� �迭���� �ؽø��� Ű������ ����ؼ� ī��Ʈ ���
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}