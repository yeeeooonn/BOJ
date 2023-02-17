import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); //N:입력받는 수
        int count = 0;// count: 봉지 개수
        
        while(true) {
            if(N%5 ==0) { //5로 나누어 떨어질 때
                bw.write(N/5+count+"");
                break;
            } else if(N<0){
                bw.write("-1");
                break;
            }
            N = N-3; //n에 3kg를 빼고 count를 늘려줌 -> 3kg 봉지를 하나 든 것과같다
            count ++;
        }
        br.close();
        bw.flush();
        bw.close();        
        
    }
}