import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    static int[] permNums;
    static int[] calcs;
    static boolean[] isPlus;
    static boolean[] visited;
    static int plusNum, mulNum;
    static int result;
    static ArrayList<Integer> list ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        isPlus= new boolean[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //더하기, 곱하기 개수 구하기
        st = new StringTokenizer(br.readLine());
        plusNum = Integer.parseInt(st.nextToken());
        mulNum = Integer.parseInt(st.nextToken());
        
        //순서 배치 정하기
        permNums= new int[N];
        visited= new boolean[N];
        perm(0);


        System.out.println(result);
        
    }

    private static void perm(int cnt) {
        if(cnt == N) {
            //plus의 개수만큼 combi 돌리기
            combi(0,0);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            permNums[cnt] = nums[i];
            perm(cnt+1);
            permNums[cnt] = 0;
            visited[i] = false;
        }

    }

    private static void combi(int cnt,int start) {
        if(cnt == plusNum) {
            //계산 -> plus 먼저, 그후 계산
            result = Math.max(result, calc());
            return;
        }
        for (int i = start; i < N-1; i++) {
            isPlus[i] = true;
            combi(cnt+1, i+1);
            isPlus[i] = false;
        }
    }

    private static int calc() {
        int calc = 1;
        calcs = new int[N];
        calcs = Arrays.copyOf(permNums,N);
        list = new ArrayList<>();


        //더하기 먼저 계산
        for (int i = 0; i < N-1; i++) {
            if(isPlus[i]) {
                calcs[i+1] = calcs[i] = calcs[i] + calcs[i+1];
                if( (i == N-2) || (i != N-2 && !isPlus[i+1])) {
                    list.add(calcs[i]);
                }
            }
            if(!isPlus[i]) {
                if(i != 0 && isPlus[i-1]) continue;
                if(i == N-2) {
                    list.add(calcs[i]);
                    list.add(calcs[i+1]);
                }
                if((i!=N-2 && !isPlus[i+1])) {
                    list.add(calcs[i]);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            calc *= list.get(i);
        }

        return calc;
    }
}