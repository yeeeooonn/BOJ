import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static long[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken()); //A
            arr[i][1] = Long.parseLong(st.nextToken()); //B
            arr[i][2] = Long.parseLong(st.nextToken()); //C
        }

        long start = 1;
        long end = 2_147_483_647;

        while(start <= end) {
            long mid = (start+end)/2;
            if(checkOdd(mid)) {
                //홀수면 범위 아래로
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        countResult(start);


    }

    private static void countResult(long start) {
        long count = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i][0]<= start && start<= arr[i][1] && (start-arr[i][0])%arr[i][2] == 0) {
                count++;
            }
        }

        if(count%2 == 1) {
            System.out.println(start+" "+count);
        }else {
            System.out.println("NOTHING");
        }

    }

    private static boolean checkOdd(long mid) {
        //mid보다 같거나 작은 수 카운트해서 홀수개인지 확인
        long count = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i][0] <= mid){
                //mid가 시작점보다 크거나 같을때만
                long answer = Math.min(mid, arr[i][1]) - arr[i][0] +1;

                if(answer % arr[i][2] == 0) {
                    count += answer / arr[i][2];
                }else {
                    count += answer / arr[i][2] + 1;
                }
            }

        }
        return count % 2 == 1;
    }
}