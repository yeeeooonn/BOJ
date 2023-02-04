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
        visit = new boolean[N]; //방문 했는지 확인하는 배열_ 기본값: false
        dfs(N,M,0);
        System.out.println(sb);
        

    }
    public static void dfs(int N, int M, int depth) {
        if(depth == M) { //깊이가 M과 같아지면 저장된 배열 출력
            for(int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = 0; i<N; i++) { 
            if(!visit[i]) { //방문하지 않았다면(false)
                visit[i] = true; //방문상태 (true)로 바꾸고
                arr[depth] =i+1; //배열에 해당 값+1해서 저장(0부터이기 때문)
                dfs(N,M,depth+1); //다음 자식 노드 방문을 위한 재귀호출
                visit[i] = false; //방문이 끝나고 돌아오면 방문하지 않은 상태로 변경
            }
        }
    }
}