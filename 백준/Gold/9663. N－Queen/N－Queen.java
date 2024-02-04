import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] board;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N]; //행 -> 인덱스, 열 -> 값

        queen(0);

        System.out.println(answer);

    }

    private static void queen(int depth) {
        if(depth == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            board[depth] = i;
            if(check(depth)) {
                queen(depth+1);
            }

        }

    }
    static boolean check(int depth) {
        for (int i = 0; i < depth; i++) { //세로로 같은 칸이 있는지, 대각선에 위치 해 있는지
            if(board[i] == board[depth] || (depth - i == Math.abs(board[depth] - board[i]))) return false;
        }
        return true;
    }

}