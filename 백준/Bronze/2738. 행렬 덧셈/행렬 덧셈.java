import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int arr1[][] = new int[N][M];
        int arr2[][] = new int[N][M];
        int result[][] = new int[N][M];
        for(int i = 0; i <N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <M; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i <N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <M; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i <N; i++) {
            for(int j = 0; j <M; j++) {
                result[i][j] = arr1[i][j]+arr2[i][j];
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }
}