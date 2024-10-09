import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] nums;
    static int[][] min;
    static int[][] max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N][3];
        min = new int[N][3];
        max = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                if(i == 0) {
                    //초기값
                    min[i][j] = max[i][j] = nums[i][j];
                }
            }
        }


        for (int i = 1; i < N; i++) {

            min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + nums[i][0];
            min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + nums[i][1];
            min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + nums[i][2];

            max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + nums[i][0];
            max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + nums[i][1];
            max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + nums[i][2];

        }

        int minN = Math.min(Math.min(min[N-1][0], min[N-1][1]), min[N-1][2]);
        int maxN = Math.max(Math.max(max[N-1][0], max[N-1][1]), max[N-1][2]);

        System.out.println(maxN +" "+ minN);

    }
}