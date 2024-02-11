import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sudoku;
    static int N = 9;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        next(0,0);

    }
    static void next(int row, int col) {
        if(col == N) {
            next(row+1, 0);
            return;
        }
        if(row == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }


        if(sudoku[row][col] == 0) {
            for (int i = 1; i <= N; i++) {
                if(check(row,col,i)) {
                    sudoku[row][col] = i;
                    next(row, col+1);
                }
            }
            sudoku[row][col] = 0;
            return;
        }
        next(row, col+1);

    }
    static boolean check(int row, int col, int value) {
        //가로
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == value) {
                return false;
            }
        }
        //세로
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == value) {
                return false;
            }
        }
        //작은 사각형
        int startR = (row/3) * 3;
        int startC = (col/3) * 3;

        for (int i = startR; i < startR +3; i++) {
            for (int j = startC; j < startC + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}