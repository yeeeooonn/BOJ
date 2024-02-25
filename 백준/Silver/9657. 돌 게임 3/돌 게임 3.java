import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[] isWin; //i개 돌이 남아있을 때 이길 수 있는지
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isWin = new boolean[1001];
        isWin[1] = true;
        isWin[3] = true;
        isWin[4] = true;

        for (int i = 5; i <= N; i++) {
            if(!isWin[i-1] || !isWin[i-3] || !isWin[i-4]) {
                isWin[i] = true;
            }
        }
        if(isWin[N]) {
            System.out.println("SK");
        }else {
            System.out.println("CY");
        }

    }
}