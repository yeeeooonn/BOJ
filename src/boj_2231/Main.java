package boj_2231;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String N = br.readLine(); // �Է°� N
        int A = Integer.parseInt(N); //int�� ����ȯ
        int result = 1000001;
        
        for(int i = 0; i<A; i++) {
            int number = i;
            int sum = i;
            
            while(number != 0) { //sum�� �� �ڸ� �� ���ϱ�
                sum += number%10;
                number /= 10;
            }
            
            if(sum == A) { //A�� ���� ������ result�� i�� ����
                if(result > i) {
                    result = i;
                }
            }
        }
        
        if(result == 1000001) { //�����ڰ� ���°��
            bw.write(0+"");
        } else {
            bw.write(result+"");
        }
        
        br.close();
        bw.flush();
        bw.close();
        
    }
}