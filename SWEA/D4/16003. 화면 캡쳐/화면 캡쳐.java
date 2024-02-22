import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static int maxCnt;
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());
            maxCnt = 50;
            cnt = 0;

            sb.append("#").append(t);
            sort(1);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void sort(int number){

        while (true){
            if (number > N || cnt == maxCnt) {
                return;
            }

            cnt++;
            sb.append(" ").append(number).append(".png");

            sort(number*10);

            if (number%10 == 9) {
                break;
            }

            number++;
        }
    }
}