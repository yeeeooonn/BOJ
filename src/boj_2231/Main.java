package boj_2231;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String N = br.readLine(); // 입력값 N
        int A = Integer.parseInt(N); //int로 형변환
        int result = 1000001;
        
        for(int i = 0; i<A; i++) {
            int number = i;
            int sum = i;
            
            while(number != 0) { //sum에 각 자리 수 더하기
                sum += number%10;
                number /= 10;
            }
            
            if(sum == A) { //A와 합이 같으면 result에 i값 대입
                if(result > i) {
                    result = i;
                }
            }
        }
        
        if(result == 1000001) { //생성자가 없는경우
            bw.write(0+"");
        } else {
            bw.write(result+"");
        }
        
        br.close();
        bw.flush();
        bw.close();
        
    }
}