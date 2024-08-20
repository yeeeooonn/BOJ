import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T,N,count;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
//            System.out.println(t+"번째--------------------------");
            N = Integer.parseInt(br.readLine());
            count = 0;
            num = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);

            for (int i = 0; i <= N-3; i++) { //a점 범위 0 ~ N-3
                for (int j = i+1; j <= N-2; j++) { //b점 범위 1 ~ N-2
//                    System.out.println("a 좌표, b좌표 : "+num[i]+", "+num[j]);
                    int point = 2 * num[j] - num[i]; //찾아야 할 c점

                    int start = j+1;
                    int end = N-1;

                    while (start < end) {
                        int mid = (start + end) / 2;

                        if(point <= num[mid]) {
                            end = mid;
                        }else {
                            start = mid+1;
                        }

                    }
//                    System.out.println(point+" "+num[start] +" "+num[end]);
                    if(num[start] == point) { //찾는 수가 있으면
//                        System.out.println("카운트업");
                        count++;
                    }

                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);

    }
}