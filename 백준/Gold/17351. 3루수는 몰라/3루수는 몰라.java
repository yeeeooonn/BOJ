import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String str;
    static char c;
    static int[][] ground;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ground = new int[N+1][N+1];

        for (int i = 0; i <= N; i++) {
            ground[0][i] = -1;
        }
        for (int i = 0; i <= N; i++) {
            ground[i][0] = -1;
        }

        for (int i = 1; i <= N; i++) {
            str = br.readLine();
            for (int j = 1; j <= N ; j++) {
                //위랑 왼쪽 보고 최댓값 갱신
                c = str.charAt(j-1);

                //지금까지 최댓값 갱신
                ground[i][j] = Math.max(ground[i-1][j], ground[i][j-1]);

                if(c == 'M') {
                    ground[i][j] = ground[i][j] / 4 * 4 +1;

                }else if(c == 'O') {
                    check(i, j, 1);
                }else if(c == 'L') {
                    check(i, j, 2);
                }else if(c == 'A') {
                    check(i, j, 3);
                }else {
                    ground[i][j] = ground[i][j] / 4 * 4;
                }

            }
        }
//        for (int i = 1; i <= N ; i++) {
//            for (int j = 1; j <= N ; j++) {
//                System.out.print(ground[i][j] +" ");
//            }
//            System.out.println();
//        }
        System.out.println(ground[N][N]/4);

    }
    static void check(int i , int j, int num) {
        if(ground[i-1][j] % 4 != num && ground[i][j-1] % 4 != num) {
            //이어지는 문자가 없을때
            ground[i][j] = ground[i][j] / 4 * 4;
            return;
        }
        int countBefore = ground[i][j] / 4;
        int countAfter = 0;

        if(ground[i-1][j] % 4 == num) {
            countAfter = (ground[i-1][j]+1) / 4;
            if(countAfter >= countBefore) { //MOLA 만든 횟수가 크거나 같으면
                ground[i][j] = ground[i-1][j]+1;
            }
        }
        if(ground[i][j-1] % 4 == num) {
            countAfter = (ground[i][j-1]+1) / 4;
            if(countAfter >= countBefore) { //MOLA 만든 횟수가 크거나 같으면
                ground[i][j] = ground[i][j-1]+1;
            }
        }

        if(ground[i-1][j] % 4 == num && ground[i][j-1] % 4 == num) {
            countAfter = Math.max((ground[i-1][j]+1) / 4, (ground[i][j-1]+1) / 4);
            if(countAfter >= countBefore) { //MOLA 만든 횟수가 크거나 같으면
                ground[i][j] = Math.max(ground[i-1][j]+1, ground[i][j-1]+1);
            }
        }

    }
}