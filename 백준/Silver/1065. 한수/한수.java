import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num = Integer.parseInt(br.readLine());
        
        int result = d(num);
        
        br.close();
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
    
    public static int d(int num) {
        int count = 0;
        if(num <100) {
            return num;
        } else {
            count = 99;
            if(num == 1000) {
                num = 999; //예외처리 1000은 등차수열 아니니까 999로 취급
            }
            
            for(int i = 100; i <= num ; i++) {
                int one = i % 10;
                int ten = (i/10)%10;
                int hun = i/100;
                
                if((hun-ten) == ((ten-one))) {
                    count ++;
                }
            }
        }

        return count;
    }
}