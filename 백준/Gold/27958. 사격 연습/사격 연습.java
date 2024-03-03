import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] attack;
    static int result;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        int[][] first = new int[N][N];
        int[][] board = new int[N][N];

        attack = new int[K];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                first[i][j] = board[i][j];
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            attack[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            shoot(0, i, 0, board, first); //몇번째 공격인지, 몇번째 줄 인지, 현재 점수, 현재 보드 상태, 현재 초기 보드판 상태
        }

        System.out.println(result);


    }
    static void shoot(int depth, int row, int score, int[][] board, int[][] first) {
        result = Math.max(result, score);
        if(depth == K) {
            return;
        }
        int[][] tmpBoard = new int[N][N];
        int[][] tmpFirst = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmpBoard[i][j] = board[i][j];
                tmpFirst[i][j] = first[i][j];
            }
        }


        for (int i = 0; i < N; i++) {
            if(tmpBoard[row][i] > 0) {
                //공격
                if(tmpBoard[row][i] >= 10) {
                    //기초 보드가 10 이상이면 바로 보너스 추가 & 보드 초기화
                    score += tmpBoard[row][i];
                    tmpBoard[row][i] = 0;
                    tmpFirst[row][i] = 0;
                }else if(tmpBoard[row][i] - attack[depth] <= 0) {
                    //아니라면 & 0 이하가 된다면 기초 점수 추가 + 보드 현재위치 초기화 & 4방향 표적 추가
                    score += tmpFirst[row][i];
                    int plus = tmpFirst[row][i]/4;
                    tmpBoard[row][i] = 0;
                    tmpFirst[row][i] = 0;

                    for (int d = 0; d < 4; d++) {
                        int nr = row + dr[d];
                        int nc = i + dc[d];
                        if(!check(nr,nc)) continue;
                        if(tmpBoard[nr][nc] == 0) {
                            tmpBoard[nr][nc] = plus;
                            tmpFirst[nr][nc] = plus;
                        }
                    }

                }else {
                    //그것도아니면 현재보드 점수만 깎음
                    tmpBoard[row][i] -= attack[depth];
                }
                //다음 공격 진행
                for (int j = 0; j < N; j++) {
                    shoot(depth+1, j, score, tmpBoard, tmpFirst); //몇번째 공격인지, 몇번째 줄 인지, 현재 점수, 현재 보드 상태, 현재 초기 보드판 상태
                }
                break;
            }
        }

    }
    static boolean check(int nr, int nc) {
        return nr>=0 && nr<N && nc>=0 && nc<N;
    }
}