package boj_1260;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[] check;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args)throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        check = new boolean[N+1];
        
        for(int i = 0 ; i < M; i++){
            st= new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e] = 1;
            arr[e][s] = 1;
        }
        
        dfs(V);
        bw.write("\n");
        bfs(V);
        
        br.close();
        bw.flush();
        bw.close();
        
    }
    
    public static void dfs(int start) throws IOException {
        bw.write(start+" ");
        check[start] = true;
        
        for(int i = 1; i < check.length; i++ ) {
            if((i != start) && (check[i] == false) && (arr[start][i] == 1))
                dfs(i);
        }
        
    }
    
    public static void initCheck(){ //check�迭 �ʱ�ȭ
        for(int i = 0 ; i < check.length; i++) check[i] = false;
    }
    
    public static void bfs(int start) throws IOException{
        // check�迭 �ʱ�ȭ
        initCheck();
        Queue<Integer> queue = new LinkedList<>();

        // ó�� ���۳�� �߰�
        queue.add(start);
        // ó�� ���۳�� �湮ó��
        check[start] = true;

        while(!queue.isEmpty()){
            int num = queue.poll();
            bw.write(num + " ");

            for(int i = 1; i < check.length; i++){
                // ���� ���� �ٸ� ��� �� && �̹湮 && ������ ����
                if(i != num && check[i] == false && arr[num][i] == 1) {
                    // ��� �߰�
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
        bw.write("\n");
    }
}