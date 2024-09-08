import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String arr[][] = new String[N][2];
        
        for(int i = 0; i<N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }
        
        Arrays.sort(arr, (arr1,arr2)-> {
                return Integer.compare(Integer.parseInt(arr1[0]), Integer.parseInt(arr2[0]));
        });
        
        for(int i = 0; i<N; i++) {
            bw.write(arr[i][0] +" "+ arr[i][1] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}