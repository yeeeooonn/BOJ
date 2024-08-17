import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); //테스트케이스 개수
        int arr [][] = new int[N][2]; //몸무게,키를 저장할 2차원배열 생성
        
        for(int i = 0; i <N; i++) { //몸무게 키 저장
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i<N; i++) {
            int rank = 1;
            for(int j = 0; j<N; j++) {
                if((arr[i][0] < arr[j][0])&&(arr[i][1] < arr[j][1]))
                    rank++;
            }
            bw.write(rank+" ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}