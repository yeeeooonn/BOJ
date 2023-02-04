package boj_2447;

import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args)throws IOException {
       
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                star(i,j);
            }
            bw.write("\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void star(int x, int y) throws IOException {
        
        if(x<3 && y<3) {
            if(x%3 ==1 && y%3==1) {
                bw.write(" ");
            } else {
                bw.write("*");
            }
        }else{
            if(x%3 ==1 && y%3==1) {
                bw.write(" ");
            } else {
                star(x/3,y/3);
            }
        }

    }
}