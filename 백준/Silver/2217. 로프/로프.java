import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int rope[] = new int[N];
        for(int i = 0; i<N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(rope);

        int maxWeight = 0;
        int sum = 0;
        
        for(int i = 0; i<N; i++) {
            sum = rope[i]*(N-i);
            if(maxWeight < sum) {
                maxWeight = sum;
            }
        }
        
        br.close();
        bw.write(maxWeight+"");
        bw.flush();
        bw.close();
    }
}