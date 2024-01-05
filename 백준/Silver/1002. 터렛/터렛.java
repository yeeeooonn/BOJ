import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); //테스트케이스 개수
        
        for(int i =0; i<N; i++){ //테스트케이스 개수만큼 반복
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            
            int dis = (int)Math.pow((x1-x2),2) + (int)Math.pow((y1-y2),2); // (x1,y1)과 (x2,y2) 거리 제곱
            int sumr = (int)Math.pow(r1+r2, 2); //반지름 합의 제곱
            int subr = (int)Math.pow(Math.abs(r2-r1), 2); //반지름 차의 제곱
            
            if((x1==x2)&&(y1==y2)&&(r1==r2)) {
                bw.write("-1\n");
            } else if (dis > sumr) { //반지름 합보다 거리가 길때 (만나지 않는다)
                bw.write("0\n");
            } else if( dis < subr) { //원안에 원이 있으나 내접하지 않을 때 (만나지 않는다)
            	bw.write("0\n");
            } else if (dis == subr) { //내접할때 (한 점에서 만난다)
            	bw.write("1\n");
            } else if(dis == sumr) { //외접할때 (한 점에서 만난다)
            	bw.write("1\n");
            }  else { //반지름 합보다 거리가 짧을때 (두 점에서 만난다)
            	bw.write("2\n");
            }
           
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}