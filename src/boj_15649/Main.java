package boj_15649;

import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String num = br.readLine();
        StringTokenizer st = new StringTokenizer(num, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr= new int[M];
        visit = new boolean[N]; //�湮 �ߴ��� Ȯ���ϴ� �迭_ �⺻��: false
        dfs(N,M,0);
        System.out.println(sb);
        

    }
    public static void dfs(int N, int M, int depth) {
        if(depth == M) { //���̰� M�� �������� ����� �迭 ���
            for(int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = 0; i<N; i++) { 
            if(!visit[i]) { //�湮���� �ʾҴٸ�(false)
                visit[i] = true; //�湮���� (true)�� �ٲٰ�
                arr[depth] =i+1; //�迭�� �ش� ��+1�ؼ� ����(0�����̱� ����)
                dfs(N,M,depth+1); //���� �ڽ� ��� �湮�� ���� ���ȣ��
                visit[i] = false; //�湮�� ������ ���ƿ��� �湮���� ���� ���·� ����
            }
        }
    }
}