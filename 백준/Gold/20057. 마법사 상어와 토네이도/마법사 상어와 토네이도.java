import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,r,c,result;
    static int[][] board;
    static int[] dr = {0, 1, 0, -1};//왼아오위 순
    static int[] dc = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        r = N/2;
        c = N/2;
        int direction = 0; //왼아오위
        int keep = 0;
        //토네이도 순서 왼, 아, 오, 위 인데 왼,오 갈때는 횟수+1 해서 이동
        while(true) {
            if(direction==0 || direction == 2) {
                keep++;
            }

            for (int i = 0; i < keep; i++) {
                move(direction);
                if(r == 0 && c == 0) {
                    break;
                }
            }

            direction++;
            direction%=4;

            if(r == 0 && c == 0) {
                break;
            }

        }
        System.out.println(result);


    }
    static void move(int dir) {
        int nr = r + dr[dir];
        int nc = c + dc[dir];
        if(check(nr,nc) && board[nr][nc] != 0) {
            //나눠주기
            int init = board[nr][nc];
            int give = 0;

            //r, c관점으로 왼,오 이동일 때는 위아래 한칸씩, 위아래이동일떄는 왼오한칸씩
            for (int d = 0; d < 4; d++) {
                if((dir + d)%2 == 0) continue;
                int r1 = r + dr[d];
                int c1 = c + dc[d];
                if(!check(r1,c1)) {
                    result += init/100;
                }else {
                    board[r1][c1] += init/100;
                }
                give += init/100;

            }

            //nr, nc관점으로 왼오이동일때는 위아래 두칸씩, 위아래이동일때는 왼오두칸씩
            for (int d = 0; d < 4; d++) {
                if((dir + d)%2 == 0) continue;
                int r1 = nr + dr[d];
                int c1 = nc + dc[d];
                if(!check(r1,c1)) {
                    result += init*7/100;
                }else {
                    board[r1][c1] += init*7/100;
                }
                give += init*7/100;

            }

            for (int d = 0; d < 4; d++) {
                if((dir + d)%2 == 0) continue;
                int r1 = nr + 2 * dr[d];
                int c1 = nc + 2 * dc[d];
                if(!check(r1,c1)) {
                    result += init*2/100;
                }else {
                    board[r1][c1] += init*2/100;
                }
                give += init*2/100;

            }


            //nr+1, nc+1관점으로 왼오이동일때는 위아래 한칸씩, 위아래이동일떄는 왼오한칸씩
            nr += dr[dir];
            nc += dc[dir];
            for (int d = 0; d < 4; d++) {
                if((dir + d)%2 == 0) continue;
                int r1 = nr + dr[d];
                int c1 = nc + dc[d];
                if(!check(r1,c1)) {
                    result += init/10;
                }else {
                    board[r1][c1] += init/10;
                }
                give += init/10;

            }

            //nr+2, nc+2에 5퍼센트
            if(!check(nr+dr[dir], nc+dc[dir])) {
                result += init * 5/100;
            }else {
                board[nr+dr[dir]][nc+dc[dir]] += init * 5/100;
            }
            give += init * 5/100;


            //남은거 a에 저장
            if(!check(nr,nc)) {
                result += (init - give);
            }else {
                board[nr][nc] += (init - give);
            }

        }

        r += dr[dir];
        c += dc[dir];
        board[r][c] = 0;

    }
    static boolean check(int nr, int nc) {
        return nr>=0 && nr<N && nc>=0 && nc<N;
    }
}