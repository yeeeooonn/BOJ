import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[] hour;
    static int[] price;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        hour = new int[N];
        price = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            hour[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N+15];
        subset(0,0, visited);

        System.out.print(result);

    }
    static void subset(int depth, int sum, boolean[] visited) {

        if(depth == N) {
            if(result < sum) {
                result = sum;
            }
            return;
        }

        //선택안하고
        subset(depth+1, sum, visited);

        //선택하고
        if(check(depth, visited)) {
            for (int i = 0; i < hour[depth]; i++) {
                visited[depth+i] = true;
            }
            subset(depth+1, sum+price[depth], visited);
            for (int i = 0; i < hour[depth]; i++) {
                visited[depth+i] = false;
            }
        }

    }
    static boolean check(int depth, boolean[] visited) {
        for (int i = 0; i < hour[depth]; i++) {
            if(visited[depth+i] || depth+i >= N) {
                return false;
            }
        }
        return true;
    }
}