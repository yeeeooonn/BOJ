import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long S = Long.parseLong(br.readLine());
        
        long sum = 0;
        long N = 1;
        
        while(sum < S){
            sum += N;
            N++;
        }
        
        if(sum == S)
        	bw.write(N-1+"");
        else
        	bw.write(N-2+"");
        
        br.close();
        bw.flush();
        bw.close();
        
    }
}