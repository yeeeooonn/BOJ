import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int bottom[] = new int[H+1]; //bottom[i] : i 높이에서 석순 개수
        int top[] = new int[H+1]; //top[i] : i 높이에서 종유석 개수

        for (int i = 0; i < N/2; i++) {
            int b = Integer.parseInt(br.readLine());
            int t = Integer.parseInt(br.readLine());
            bottom[b]++;
            top[H+1-t]++;
        }

        for (int i = H; i > 0; i--) {
            bottom[i-1] += bottom[i];
        }

        for (int i = 1; i <= H; i++) {
            top[i] += top[i-1];
        }

        int minNum = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i <= H; i++) {
            int sum = bottom[i] + top[i];
            if(sum < minNum) {
                minNum = sum;
                result = 1;
            } else if (minNum == sum) {
                result +=1;
            }
        }
        System.out.println(minNum +" "+ result);
    }
}