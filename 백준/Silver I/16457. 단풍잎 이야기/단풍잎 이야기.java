import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static  int n, m, k, answer;
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        visited = new boolean[2*n+1];
        answer = 0;
        
        combi(0,1);

        System.out.println(answer);

    }
    static void combi(int depth, int start) {
        if(depth == n) {

            int result = 0;
            for (int i = 0; i < m; i++) {
                int count = 0;
                for (int j = 0; j < k; j++) {
                    if(visited[list[i].get(j)]) count++;
                }
                if(count == k) result++;
            }

            answer = Math.max(answer, result);

            return;
        }
        for (int i = start; i <= 2*n; i++) {
            visited[i] = true;
            combi(depth+1, i+1);
            visited[i] = false;
        }

    }
}