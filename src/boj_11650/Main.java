package boj_11650;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int arr [][] = new int[N][2];
        
        for(int i = 0; i<N; i++) { //2차원 배열에 x,y값 저장
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        //Arrays.sort는 1차원배열 정렬식이기 때문에 람다식을 활용해서 정렬
        Arrays.sort(arr, (arr1,arr2) -> {
            if(arr1[0] == arr2[0]) //비교대상의 x값이 같다면
                return Integer.compare(arr1[1],arr2[1]); //y끼리 비교
            else //x값이 다른경우
                return Integer.compare(arr1[0],arr2[0]); //x끼리 비교
        });
        
        for(int i = 0; i<N; i++) {
            bw.write(arr[i][0] +" "+arr[i][1]+"\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}