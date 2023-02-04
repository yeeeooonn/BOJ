package boj_1931;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int N = Integer.parseInt(br.readLine());
        int time[][] = new int[N][2];
        StringTokenizer st;
        
        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        //끝나는 시간을 기준으로 정렬, 끝나는 시간이 같다면 시작하는 시간 오름차순 정렬
        Arrays.sort(time, (arr1, arr2) -> {
            if(arr1[1] == arr2[1])
                return Integer.compare(arr1[0],arr2[0]);
            return arr1[1]- arr2[1];
        });
        
        int count = 0;
        int end_time = 0;
        for(int i =0; i < N; i++) {
            if(end_time <= time[i][0]) {
                count++;
                end_time = time[i][1];
            }
        }
        br.close();
        bw.write(count+"");
        bw.flush();
        bw.close();
        

    }
}